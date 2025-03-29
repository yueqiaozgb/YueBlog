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
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.entity.Tag;
import top.yueqiao.blog.domain.model.vo.BlogEditVo;
import top.yueqiao.blog.domain.model.vo.BlogListItemVo;
import top.yueqiao.blog.mapper.BlogMapper;
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
        List<Tag> tags = tagMapper.selectTagListByBlogId(id);
        Blog blog = baseMapper.selectById(id);
        return IBlogMapper.INSTANCE.blogToBlogEditVo(blog, tags);
    }

    @Override
    public int insertBlog(Blog blog) {
        int length = blog.getContent().length();
        blog.setWordCount(length);
        blog.setReadTime(length / 300);
        return baseMapper.insert(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        int length = blog.getContent().length();
        blog.setWordCount(length);
        blog.setReadTime(length / 300);
        return baseMapper.updateById(blog);
    }

    @Override
    public int deleteBlogByIds(Integer[] ids) {
        LambdaQueryWrapper<Blog> lqw = new LambdaQueryWrapper<Blog>()
                .in(Blog::getId, CollUtil.toList(ids));
        return baseMapper.delete(lqw);
    }

}
