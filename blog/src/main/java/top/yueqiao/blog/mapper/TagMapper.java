package top.yueqiao.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.yueqiao.blog.domain.entity.Tag;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/28/17:40
 */
public interface TagMapper extends BaseMapper<Tag> {

    List<Tag> selectTagListByBlogId(@Param("blogId") Integer blogId);

}
