package top.yueqiao.yueblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 针对表【blog(博客表)】的数据库操作Service
 *
 * @author yueqiao
 */
public interface BlogService extends IService<Blog> {

    BlogDetailVo selectBlogDetailVoById(Long blogId);

    List<SearchBlogVo> selectSearchBlogVoList(String query);

    Map<String, Object> selectArchiveBlogVoList();

    List<NewBlogVo> selectNewBlogVoList();

    List<RandomBlogVo> selectRandomBlogList();

    PageInfo<BlogInfoVo> selectBlogInfoVoPageByTagName(String tagName, Integer pageNum);

    PageInfo<BlogInfoVo> selectBlogInfoVoPageByCategoryName(String categoryName, Integer pageNum);

    PageInfo<BlogInfoVo> selectBlogInfoVoPage(Integer pageNum);

}
