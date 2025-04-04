package top.yueqiao.blog.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.entity.BlogTag;
import top.yueqiao.blog.domain.entity.Category;
import top.yueqiao.blog.domain.entity.Tag;
import top.yueqiao.blog.domain.model.dto.BlogEditDto;
import top.yueqiao.blog.domain.model.vo.BlogEditVo;
import top.yueqiao.blog.domain.model.vo.BlogListItemVo;
import top.yueqiao.blog.domain.model.vo.BlogRandomVo;
import top.yueqiao.blog.exception.ServiceException;
import top.yueqiao.blog.mapper.BlogMapper;
import top.yueqiao.blog.mapper.BlogTagMapper;
import top.yueqiao.blog.mapper.CategoryMapper;
import top.yueqiao.blog.mapper.TagMapper;
import top.yueqiao.blog.mapstruct.IBlogMapper;
import top.yueqiao.blog.service.IBlogService;

import java.util.List;

/**
 * @author : yueqiao
 * @date : 2025/3/26 0:04
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    private final BlogTagMapper blogTagMapper;

    private final CategoryMapper categoryMapper;

    private final TagMapper tagMapper;

    @Override
    public PageResult<BlogListItemVo> selectPageBlogList(Blog blog, PageQuery pageQuery) {
        LambdaQueryWrapper<Blog> lqw = new LambdaQueryWrapper<Blog>()
                .select(Blog::getId,
                        Blog::getCategoryId,
                        Blog::getTitle,
                        Blog::getWordCount,
                        Blog::getReadTime,
                        Blog::getCreateTime)
                .like(StrUtil.isNotBlank(blog.getTitle()), Blog::getTitle, blog.getTitle())
                .eq(ObjectUtil.isNotNull(blog.getCategoryId()), Blog::getCategoryId, blog.getCategoryId());
        Page<Blog> page = page(pageQuery.build(), lqw);
        List<BlogListItemVo> list = page.getRecords().stream()
                .map(IBlogMapper.INSTANCE::blogToBlogListItemVo)
                .toList();
        return PageResult.build(list);
    }

    @Override
    public BlogEditVo selectBlogById(Integer id) {
        LambdaQueryWrapper<BlogTag> lqw = new LambdaQueryWrapper<BlogTag>()
                .eq(BlogTag::getBlogId, id);
        List<BlogTag> blogTagList = blogTagMapper.selectList(lqw);
        List<Integer> tagIdList = blogTagList.stream().map(BlogTag::getTagId).toList();
        Blog blog = baseMapper.selectById(id);
        return IBlogMapper.INSTANCE.blogToBlogEditVo(blog, tagIdList);
    }

    @Transactional
    @Override
    public int insertBlog(BlogEditDto blogEditDto) {
        int length = blogEditDto.getContent().length();
        blogEditDto.setWordCount(length);
        blogEditDto.setReadTime(length / 200);
        Blog blog = checkBlog(blogEditDto);
        baseMapper.insert(blog);
        updateBlogTag(blog.getId(), blogEditDto.getTagIdList());
        return blog.getId();
    }

    @Transactional
    @Override
    public int updateBlog(BlogEditDto blogEditDto) {
        int length = blogEditDto.getContent().length();
        blogEditDto.setWordCount(length);
        blogEditDto.setReadTime(length / 200);
        Blog blog = checkBlog(blogEditDto);
        updateBlogTag(blog.getId(), blogEditDto.getTagIdList());
        return baseMapper.updateById(blog);
    }

    private Blog checkBlog(BlogEditDto blogEditDto) {
        LambdaQueryWrapper<Category> lqw = new LambdaQueryWrapper<Category>()
                .eq(Category::getId, blogEditDto.getCategoryId());
        if (categoryMapper.selectCount(lqw) == 0) {
            throw new ServiceException("分类不存在");
        }
        LambdaQueryWrapper<Tag> lqw1 = new LambdaQueryWrapper<Tag>()
                .in(Tag::getId, blogEditDto.getTagIdList());
        if (tagMapper.selectCount(lqw1) != blogEditDto.getTagIdList().size()) {
            throw new ServiceException("标签不存在");
        }
        return IBlogMapper.INSTANCE.blogEditDtoToBlog(blogEditDto);
    }

    private int updateBlogTag(Integer blogId, List<Integer> tagIdList) {
        LambdaQueryWrapper<BlogTag> lqw = new LambdaQueryWrapper<BlogTag>()
                .eq(BlogTag::getBlogId, blogId);
        blogTagMapper.delete(lqw);
        List<BlogTag> list = tagIdList.stream()
                .map(tagId -> new BlogTag(blogId, tagId))
                .toList();
        return blogTagMapper.insertBatchSomeColumn(list);
    }

    @Override
    public int deleteBlogByIds(Integer[] ids) {
        LambdaQueryWrapper<Blog> lqw = new LambdaQueryWrapper<Blog>()
                .in(Blog::getId, CollUtil.toList(ids));
        return baseMapper.delete(lqw);
    }

    @Override
    public PageResult<BlogRandomVo> selectPageRandomBlogList() {
        Integer randomBlogLimit = 5;
        List<BlogRandomVo> blogRandomVoList = baseMapper.selectRandomBlogList(randomBlogLimit);
        return PageResult.build(blogRandomVoList);
    }

}
