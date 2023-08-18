package top.yueqiao.yueblog.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.dto.BlogDto;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.entity.BlogCategory;
import top.yueqiao.yueblog.domain.entity.BlogTag;
import top.yueqiao.yueblog.domain.vo.BlogArchiveVo;
import top.yueqiao.yueblog.domain.vo.BlogDetailVo;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;
import top.yueqiao.yueblog.domain.vo.BlogPreviewVo;
import top.yueqiao.yueblog.exception.ServiceException;
import top.yueqiao.yueblog.mapper.BlogCategoryMapper;
import top.yueqiao.yueblog.mapper.BlogMapper;
import top.yueqiao.yueblog.mapstruct.BlogConvertor;
import top.yueqiao.yueblog.service.BlogService;
import top.yueqiao.yueblog.service.BlogTagService;
import top.yueqiao.yueblog.util.MarkdownUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static top.yueqiao.yueblog.constant.Constants.Flag.BOOLEAN_SUCCESS;
import static top.yueqiao.yueblog.constant.Constants.Flag.INTEGER_SUCCESS;
import static top.yueqiao.yueblog.constant.Constants.Page.*;

/**
 * 针对表【blog(博客表)】的数据库操作Service实现
 *
 * @author yueqiao
 */
@Slf4j
@Service
@Transactional
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @Autowired
    private BlogTagService blogTagService;

    @Override
    public BlogDetailVo selectBlogDetailVoById(Long blogId) {
        BlogDetailVo blogDetailVo = baseMapper.selectBlogVoById(blogId);
        blogDetailVo.setBlogContent(MarkdownUtils.markdownToHtmlExtensions(blogDetailVo.getBlogContent()));
        return blogDetailVo;
    }

    @Override
    public Blog selectBlogByID(Long blogId) {
        return baseMapper.selectBlogByID(blogId);
    }

    @Override
    public List<BlogPreviewVo> selectSearchBlogVoList(String query) {
        return baseMapper.selectSearchBlogVoList(query);
    }

    @Override
    public Map<String, Object> selectArchiveBlogVoList() {
        List<BlogArchiveVo> archiveBlogVos = baseMapper.selectArchiveBlogVoList();
        Map<String, List<BlogArchiveVo>> archiveBlogMap = archiveBlogVos.stream()
                .collect(Collectors.groupingBy(BlogArchiveVo::getYearMonth, LinkedHashMap::new, Collectors.toList()));
        Map<String, Object> map = new HashMap<>(4);
        map.put("blogMap", archiveBlogMap);
        map.put("count", archiveBlogVos.size());
        return map;
    }

    @Override
    public List<BlogPreviewVo> selectNewBlogVoList() {
        IPage<BlogPreviewVo> page = new Page<>(CURRENT_PAGE, NEW_PAGE_SIZE);
        IPage<BlogPreviewVo> result = baseMapper.selectNewBlogVoList(page);
        return result.getRecords();
    }

    @Override
    public List<BlogPreviewVo> selectRandomBlogList() {
        return baseMapper.selectRandomBlogList(RANDOM_LIMIT_SIZE);
    }

    @Override
    public PageInfo<BlogInfoVo> selectBlogInfoVoPageByTagName(String tagName, Integer pageNum) {
        IPage<BlogInfoVo> page = new Page<>(pageNum, PAGE_SIZE);
        IPage<BlogInfoVo> result = baseMapper.selectBlogInfoVoPageByTagName(page, tagName);
        return PageInfo.build(result);
    }

    @Override
    public PageInfo<BlogInfoVo> selectBlogInfoVoPageByCategoryName(String categoryName, Integer pageNum) {
        IPage<BlogInfoVo> page = new Page<>(pageNum, PAGE_SIZE);
        IPage<BlogInfoVo> result = baseMapper.selectBlogInfoVoPageByCategoryName(page, categoryName);
        result.getRecords().forEach(blogInfoVo -> blogInfoVo.setBlogIntroduction(MarkdownUtils.markdownToHtmlExtensions(blogInfoVo.getBlogIntroduction())));
        return PageInfo.build(result);
    }

    @Override
    public PageInfo<BlogInfoVo> selectBlogInfoVoPage(Integer pageNum) {
        IPage<BlogInfoVo> page = new Page<>(pageNum, PAGE_SIZE);
        IPage<BlogInfoVo> result = baseMapper.selectBlogInfoVoPage(page);
        result.getRecords().forEach(blogInfoVo -> blogInfoVo.setBlogIntroduction(MarkdownUtils.markdownToHtmlExtensions(blogInfoVo.getBlogIntroduction())));
        return PageInfo.build(result);
    }

    @Override
    public boolean insertBlog(BlogDto blogDto) {
        Blog blog = BlogConvertor.INSTANCE.blogDto2Blog(blogDto);
        int insert1 = baseMapper.insert(blog);
        if (!ObjectUtil.equals(INTEGER_SUCCESS, insert1)) {
            throw new ServiceException("插入博客失败");
        }
        Long categoryId = blogDto.getCategory();
        BlogCategory blogCategory = new BlogCategory();
        blogCategory.setBlogId(blog.getBlogId()).setCategoryId(categoryId);
        int insert2 = blogCategoryMapper.insert(blogCategory);
        if (!ObjectUtil.equals(INTEGER_SUCCESS, insert2)) {
            throw new ServiceException("插入博客分类失败");
        }
        List<Long> tagIdList = blogDto.getTagList();
        List<BlogTag> collect = tagIdList.stream().map(tagId -> {
            BlogTag blogTag = new BlogTag();
            blogTag.setBlogId(blog.getBlogId()).setTagId(tagId);
            return blogTag;
        }).toList();
        boolean insert3 = blogTagService.saveBatch(collect);
        if (!ObjectUtil.equals(BOOLEAN_SUCCESS, insert3)) {
            throw new ServiceException("插入博客标签失败");
        }
        return true;
    }

    @Override
    public PageInfo<BlogInfoVo> selectPageBlogInfoVoList(BlogDto blogDto, PageQuery pageQuery) {
        IPage<BlogInfoVo> result = baseMapper.selectPageBlogInfoVoList(blogDto, pageQuery.build());
        return PageInfo.build(result);
    }

    @Override
    public boolean updateBlog(BlogDto blogDto) {
        Blog blog = BlogConvertor.INSTANCE.blogDto2Blog(blogDto);
        int update1 = baseMapper.updateById(blog);
        if (!ObjectUtil.equals(INTEGER_SUCCESS, update1)) {
            throw new ServiceException("更新博客失败");
        }
        Long categoryId = blogDto.getCategory();
        LambdaUpdateWrapper<BlogCategory> lqw = new LambdaUpdateWrapper<BlogCategory>()
                .set(BlogCategory::getCategoryId, categoryId)
                .eq(BlogCategory::getBlogId, blog.getBlogId());
        int update2 = blogCategoryMapper.update(null, lqw);
        if (!ObjectUtil.equals(INTEGER_SUCCESS, update2)) {
            throw new ServiceException("更新博客分类失败");
        }
        LambdaQueryWrapper<BlogTag> lqw2 = new LambdaQueryWrapper<BlogTag>()
                .eq(BlogTag::getBlogId, blog.getBlogId());
        boolean remove3 = blogTagService.remove(lqw2);
        if (!ObjectUtil.equals(BOOLEAN_SUCCESS, remove3)) {
            throw new ServiceException("删除博客标签失败");
        }
        List<Long> tagIdList = blogDto.getTagList();
        List<BlogTag> collect = tagIdList.stream().map(tagId -> {
            BlogTag blogTag = new BlogTag();
            blogTag.setBlogId(blog.getBlogId()).setTagId(tagId);
            return blogTag;
        }).toList();
        boolean insert4 = blogTagService.saveBatch(collect);
        if (!ObjectUtil.equals(BOOLEAN_SUCCESS, insert4)) {
            throw new ServiceException("插入博客标签失败");
        }
        return true;
    }

    @Override
    public boolean deleteBlog(Long id) {
        int delete1 = baseMapper.deleteById(id);
        if (!ObjectUtil.equals(INTEGER_SUCCESS, delete1)) {
            throw new ServiceException("删除博客失败");
        }
        LambdaQueryWrapper<BlogCategory> lqw = new LambdaQueryWrapper<BlogCategory>()
                .eq(BlogCategory::getBlogId, id);
        int delete2 = blogCategoryMapper.delete(lqw);
        if (!ObjectUtil.equals(INTEGER_SUCCESS, delete2)) {
            throw new ServiceException("删除博客分类失败");
        }
        LambdaQueryWrapper<BlogTag> lqw2 = new LambdaQueryWrapper<BlogTag>()
                .eq(BlogTag::getBlogId, id);
        boolean remove3 = blogTagService.remove(lqw2);
        if (!ObjectUtil.equals(BOOLEAN_SUCCESS, remove3)) {
            throw new ServiceException("删除博客标签失败");
        }
        return true;
    }

}




