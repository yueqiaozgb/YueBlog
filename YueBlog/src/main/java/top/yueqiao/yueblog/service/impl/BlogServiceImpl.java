package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.*;
import top.yueqiao.yueblog.mapper.BlogMapper;
import top.yueqiao.yueblog.service.BlogService;
import top.yueqiao.yueblog.util.MarkdownUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static top.yueqiao.yueblog.constant.Constants.Page.*;

/**
 * 针对表【blog(博客表)】的数据库操作Service实现
 *
 * @author yueqiao
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Override
    public BlogDetailVo selectBlogDetailVoById(Long blogId) {
        BlogDetailVo blogDetailVo = baseMapper.selectBlogVoById(blogId);
        blogDetailVo.setBlogContent(MarkdownUtils.markdownToHtmlExtensions(blogDetailVo.getBlogContent()));
        return blogDetailVo;
    }

    @Override
    public List<SearchBlogVo> selectSearchBlogVoList(String query) {
        return baseMapper.selectSearchBlogVoList(query);
    }

    @Override
    public Map<String, Object> selectArchiveBlogVoList() {
        List<ArchiveBlogVo> archiveBlogVos = baseMapper.selectArchiveBlogVoList();
        Map<String, List<ArchiveBlogVo>> archiveBlogMap = archiveBlogVos.stream()
                .collect(Collectors.groupingBy(ArchiveBlogVo::getYearMonth, LinkedHashMap::new, Collectors.toList()));
        Map<String, Object> map = new HashMap<>(4);
        map.put("blogMap", archiveBlogMap);
        map.put("count", archiveBlogVos.size());
        return map;
    }

    @Override
    public List<NewBlogVo> selectNewBlogVoList() {
        IPage<NewBlogVo> page = new Page<>(CURRENT_PAGE, NEW_PAGE_SIZE);
        IPage<NewBlogVo> result = baseMapper.selectNewBlogVoList(page);
        return result.getRecords();
    }

    @Override
    public List<RandomBlogVo> selectRandomBlogList() {
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

}




