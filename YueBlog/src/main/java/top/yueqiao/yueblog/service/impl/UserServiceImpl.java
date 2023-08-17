package top.yueqiao.yueblog.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.yueqiao.yueblog.domain.dto.LoginDto;
import top.yueqiao.yueblog.domain.entity.User;
import top.yueqiao.yueblog.exception.ServiceException;
import top.yueqiao.yueblog.mapper.UserMapper;
import top.yueqiao.yueblog.service.UserService;
import top.yueqiao.yueblog.util.SecurityUtils;

import java.util.HashMap;
import java.util.Map;

/**
* @author yueqiao
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-08-17 14:47:04
*/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Override
    public Map<String, String> login(LoginDto loginDto) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, loginDto.getUsername());
        User user = baseMapper.selectOne(lqw);
        if (ObjectUtil.isNull(user)) {
            throw new ServiceException("用户名错误");
        }
        if (!SecurityUtils.matchesPassword(loginDto.getPassword(), user.getPassword())) {
            throw new ServiceException("密码错误");
        }
        StpUtil.login(user.getId());
        Map<String, String> map = new HashMap<>();
        map.put("token", StpUtil.getTokenInfo().tokenValue);
        map.put("user", JSON.toJSONString(user));
        log.info(JSON.toJSONString(map));
        return map;
    }

}




