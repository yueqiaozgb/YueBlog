package top.yueqiao.blog.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.blog.entity.model.User;
import top.yueqiao.blog.exception.ServiceException;
import top.yueqiao.blog.mapper.UserMapper;
import top.yueqiao.blog.service.ILoginService;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:18
 */
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements ILoginService {

    @Override
    public int login(String username, String password) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username);
        User user = baseMapper.selectOne(lqw);
        if (ObjectUtil.isNull(user)) {
            throw new ServiceException("用户不存在");
        }
        if (!StrUtil.equals(user.getPassword(), SaSecureUtil.md5(password))) {
            throw new ServiceException("密码错误");
        }
        StpUtil.login(user.getId());
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(SaSecureUtil.md5("123456"));
    }

}
