package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.ArchiveBlogVo;
import top.yueqiao.yueblog.domain.vo.BlogDetailVo;
import top.yueqiao.yueblog.domain.vo.SearchBlogVo;
import top.yueqiao.yueblog.mapper.BlogMapper;
import top.yueqiao.yueblog.service.BlogService;
import top.yueqiao.yueblog.util.MarkdownUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

}




