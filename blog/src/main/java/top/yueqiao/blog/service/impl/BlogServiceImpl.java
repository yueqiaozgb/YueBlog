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
import top.yueqiao.blog.domain.model.dto.BlogListDto;
import top.yueqiao.blog.domain.model.vo.*;
import top.yueqiao.blog.exception.ServiceException;
import top.yueqiao.blog.mapper.BlogMapper;
import top.yueqiao.blog.mapper.BlogTagMapper;
import top.yueqiao.blog.mapper.CategoryMapper;
import top.yueqiao.blog.mapper.TagMapper;
import top.yueqiao.blog.mapstruct.IBlogMapper;
import top.yueqiao.blog.service.IBlogService;
import top.yueqiao.blog.util.MarkdownUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public PageResult<BlogListItemVo> selectPageBlogList(BlogListDto blogListDto, PageQuery pageQuery) {
        LambdaQueryWrapper<Blog> lqw = new LambdaQueryWrapper<Blog>()
                .select(Blog::getId,
                        Blog::getCategoryId,
                        Blog::getTitle,
                        Blog::getWordCount,
                        Blog::getReadTime,
                        Blog::getCreateTime)
                .like(StrUtil.isNotBlank(blogListDto.getTitle()), Blog::getTitle, blogListDto.getTitle())
                .eq(ObjectUtil.isNotNull(blogListDto.getCategoryId()), Blog::getCategoryId, blogListDto.getCategoryId());
        Page<Blog> page = page(pageQuery.build(), lqw);
        List<BlogListItemVo> list = page.getRecords().stream()
                .map(IBlogMapper.INSTANCE::blogToBlogListItemVo)
                .toList();
        return PageResult.build(list, page.getTotal());
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

    @Override
    public BlogDetailVo selectBlogDetailById(Integer id) {
        Blog blog = baseMapper.selectById(id);
        BlogDetailVo blogDetailVo = IBlogMapper.INSTANCE.blogToBlogDetailVo(blog);
        Category category = categoryMapper.selectById(blog.getCategoryId());
        blogDetailVo.setCategory(category);
        LambdaQueryWrapper<BlogTag> lqw = new LambdaQueryWrapper<BlogTag>()
                .eq(BlogTag::getBlogId, id);
        List<BlogTag> blogTagList = blogTagMapper.selectList(lqw);
        List<Integer> tagIdList = blogTagList.stream().map(BlogTag::getTagId).toList();
        List<Tag> tagList = tagMapper.selectByIds(tagIdList);
        blogDetailVo.setTagList(tagList);
        blogDetailVo.setContent(MarkdownUtils.markdownToHtmlExtensions(blog.getContent()));
        return blogDetailVo;
    }

    @Transactional
    @Override
    public int insertBlog(BlogEditDto blogEditDto) {
        int length = blogEditDto.getContent().length();
        blogEditDto.setWordCount(length);
        blogEditDto.setReadTime(length / 200);
        Blog blog = checkBlog(blogEditDto);
        blog.setContent(blogEditDto.getContent());
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

    private void updateBlogTag(Integer blogId, List<Integer> tagIdList) {
        LambdaQueryWrapper<BlogTag> lqw = new LambdaQueryWrapper<BlogTag>()
                .eq(BlogTag::getBlogId, blogId);
        blogTagMapper.delete(lqw);
        List<BlogTag> list = tagIdList.stream()
                .map(tagId -> new BlogTag(blogId, tagId))
                .toList();
        blogTagMapper.insertBatchSomeColumn(list);
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

    @Override
    public PageResult<BlogInfoVo> selectPageBlogInfoVoList(PageQuery pageQuery) {
        LambdaQueryWrapper<Blog> lqw = new LambdaQueryWrapper<Blog>()
                .select(Blog::getId,
                        Blog::getCategoryId,
                        Blog::getTitle,
                        Blog::getCover,
                        Blog::getDescription,
                        Blog::getWordCount,
                        Blog::getReadTime,
                        Blog::getCreateTime);
        Page<Blog> page = page(pageQuery.build(), lqw);
        List<Blog> records = page.getRecords();
        List<Category> categoryList = categoryMapper.selectByIds(records.stream().map(Blog::getCategoryId).toList());
        Map<Integer, Category> categoryMap = categoryList.stream().collect(Collectors.toMap(Category::getId, Function.identity()));
        List<BlogTag> blogTagList = blogTagMapper.selectList(new LambdaQueryWrapper<BlogTag>()
                .in(BlogTag::getBlogId, records.stream().map(Blog::getId).toList()));
        Map<Integer, List<Integer>> blogTagMap = blogTagList.stream()
                .collect(Collectors.toMap(BlogTag::getBlogId, blogTag -> CollUtil.toList(blogTag.getTagId()),
                        (list1, list2) -> Stream.of(list1, list2).flatMap(List::stream).collect(Collectors.toList())));
        List<Tag> tagList = tagMapper.selectByIds(blogTagList.stream().map(BlogTag::getTagId).toList());
        Map<Integer, Tag> tagMap = tagList.stream().collect(Collectors.toMap(Tag::getId, Function.identity()));
        List<BlogInfoVo> blogInfoVoList = records.stream()
                .map(blog -> {
                    BlogInfoVo blogInfoVo = IBlogMapper.INSTANCE.blogToBlogInfoVo(blog);
                    blogInfoVo.setCategory(categoryMap.get(blog.getCategoryId()));
                    blogInfoVo.setTagList(blogTagMap.get(blog.getId()).stream().map(tagMap::get).toList());
                    return blogInfoVo;
                })
                .toList();
        blogInfoVoList.forEach(blogInfoVo -> blogInfoVo.setDescription(MarkdownUtils.markdownToHtmlExtensions(blogInfoVo.getDescription())));
        return PageResult.build(blogInfoVoList, page.getTotal());
    }

}
