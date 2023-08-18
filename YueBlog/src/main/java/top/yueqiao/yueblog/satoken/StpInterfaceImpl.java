package top.yueqiao.yueblog.satoken;

import cn.dev33.satoken.stp.StpInterface;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yueqiao.yueblog.domain.entity.User;
import top.yueqiao.yueblog.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yueqiao
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return new ArrayList<>();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>()
                .eq(User::getId, loginId)
                .select(User::getRoleKey);
        return userMapper.selectList(lqw).stream().map(User::getRoleKey).toList();
    }

}
