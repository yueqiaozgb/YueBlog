package top.yueqiao.yueblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import top.yueqiao.yueblog.domain.dto.BlogDto;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.*;

import java.util.List;

/**
 * 针对表【blog(博客表)】的数据库操作Mapper
 *
 * @author yueqiao
 */
public interface BlogMapper extends BaseMapper<Blog> {

    Blog selectBlogByID(@Param("blogId") Long blogId);

    BlogDetailVo selectBlogVoById(@Param("blogId") Long blogId);

    List<BlogPreviewVo> selectSearchBlogVoList(@Param("query") String query);

    List<BlogArchiveVo> selectArchiveBlogVoList();

    IPage<BlogPreviewVo> selectNewBlogVoList(IPage<BlogPreviewVo> page);

    List<BlogPreviewVo> selectRandomBlogList(@Param("randomLimitSize") int randomLimitSize);

    IPage<BlogInfoVo> selectBlogInfoVoPageByTagName(IPage<BlogInfoVo> page, String tagName);

    IPage<BlogInfoVo> selectBlogInfoVoPageByCategoryName(IPage<BlogInfoVo> page, String categoryName);

    IPage<BlogInfoVo> selectBlogInfoVoPage(IPage<BlogInfoVo> page);

    IPage<BlogInfoVo> selectPageBlogInfoVoList(@Param("blogDto")BlogDto blogDto, Page<Object> build);

}




