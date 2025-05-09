package top.yueqiao.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.model.vo.BlogArchiveVo;
import top.yueqiao.blog.domain.model.vo.BlogRandomVo;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/05/17:07
 */
public interface BlogMapper extends BaseMapper<Blog> {

    List<BlogRandomVo> selectRandomBlogList(@Param("limit") Integer limit);

    Page<BlogArchiveVo> pageBlogArchiveVo(@Param("page") Page<BlogArchiveVo> page);

}
