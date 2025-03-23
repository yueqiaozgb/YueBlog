package top.yueqiao.blog.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.yueqiao.blog.domain.entity.User;
import top.yueqiao.blog.exception.ServiceException;
import top.yueqiao.blog.mapper.UserMapper;
import top.yueqiao.blog.mapstruct.IUserMapper;
import top.yueqiao.blog.domain.model.bo.UserBo;
import top.yueqiao.blog.service.ILoginService;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:18
 */
@Slf4j
@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements ILoginService {

    private static final Integer ADMIN = 100001;

    @Override
    public String login(String username, String password) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username);
        User user = baseMapper.selectOne(lqw);
        if (ObjectUtil.isNull(user)) {
            throw new ServiceException("用户不存在");
        }
        if (!StrUtil.equals(user.getPassword(), SaSecureUtil.md5(password))) {
            log.info("密码错误,密码: {}", SaSecureUtil.md5(password));
            throw new ServiceException("密码错误");
        }
        StpUtil.login(user.getId());
        UserBo userBo = IUserMapper.INSTANCE.userToUserBo(user);
        if (NumberUtil.equals(userBo.getId(), ADMIN)) {
            userBo.setPermissionList(ListUtil.toList("*:*:*"));
            userBo.setRoleList(ListUtil.toList("ADMIN"));
        } else {
            userBo.setRoleList(baseMapper.selectRoleListByUserId(user.getId()));
        }
        StpUtil.getSession().set("user", userBo);
        return StpUtil.getTokenValue();
    }

    public static void main(String[] args) {
        System.out.println(SaSecureUtil.md5("123456"));
    }

}
