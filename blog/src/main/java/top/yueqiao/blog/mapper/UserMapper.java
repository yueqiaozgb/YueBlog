package top.yueqiao.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.yueqiao.blog.entity.model.User;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/11/18:47
 */
public interface UserMapper extends BaseMapper<User> {

    List<String> selectRoleListByUserId(Integer userId);

}
