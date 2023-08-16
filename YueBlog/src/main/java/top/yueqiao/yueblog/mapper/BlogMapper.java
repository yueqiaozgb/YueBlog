package top.yueqiao.yueblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.*;

import java.util.List;

/**
 * 针对表【blog(博客表)】的数据库操作Mapper
 *
 * @author yueqiao
 */
public interface BlogMapper extends BaseMapper<Blog> {

    BlogDetailVo selectBlogVoById(@Param("blogId") Long blogId);

    List<SearchBlogVo> selectSearchBlogVoList(@Param("query") String query);

    List<ArchiveBlogVo> selectArchiveBlogVoList();

    IPage<NewBlogVo> selectNewBlogVoList(IPage<NewBlogVo> page);

    List<RandomBlogVo> selectRandomBlogList(@Param("randomLimitSize") int randomLimitSize);

    IPage<BlogInfoVo> selectBlogInfoVoPageByTagName(IPage<BlogInfoVo> page, String tagName);

    IPage<BlogInfoVo> selectBlogInfoVoPageByCategoryName(IPage<BlogInfoVo> page, String categoryName);

    IPage<BlogInfoVo> selectBlogInfoVoPage(IPage<BlogInfoVo> page);

}




