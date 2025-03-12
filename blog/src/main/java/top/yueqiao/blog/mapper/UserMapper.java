package top.yueqiao.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.yueqiao.blog.entity.User;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/11/18:47
 */
public interface UserMapper extends BaseMapper<User> {

    List<String> selectRoleListByUserId(@Param("userId") Integer userId);

}
