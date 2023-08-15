package top.yueqiao.yueblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.ArchiveBlogVo;
import top.yueqiao.yueblog.domain.vo.BlogDetailVo;
import top.yueqiao.yueblog.domain.vo.SearchBlogVo;

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
}




