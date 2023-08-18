package top.yueqiao.yueblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.dto.BlogDto;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.BlogDetailVo;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;
import top.yueqiao.yueblog.domain.vo.BlogPreviewVo;

import java.util.List;
import java.util.Map;

/**
 * 针对表【blog(博客表)】的数据库操作Service
 *
 * @author yueqiao
 */
public interface BlogService extends IService<Blog> {

    BlogDetailVo selectBlogDetailVoById(Long blogId);

    Blog selectBlogByID(Long blogId);


    List<BlogPreviewVo> selectSearchBlogVoList(String query);

    Map<String, Object> selectArchiveBlogVoList();

    List<BlogPreviewVo> selectNewBlogVoList();

    List<BlogPreviewVo> selectRandomBlogList();

    PageInfo<BlogInfoVo> selectBlogInfoVoPageByTagName(String tagName, Integer pageNum);

    PageInfo<BlogInfoVo> selectBlogInfoVoPageByCategoryName(String categoryName, Integer pageNum);

    PageInfo<BlogInfoVo> selectBlogInfoVoPage(Integer pageNum);

    boolean insertBlog(BlogDto blogDto);

    PageInfo<BlogInfoVo> selectPageBlogInfoVoList(BlogDto blogDto, PageQuery pageQuery);

    boolean updateBlog(BlogDto blogDto);

    boolean deleteBlog(Long id);

}
