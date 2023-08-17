package top.yueqiao.yueblog.service;

import top.yueqiao.yueblog.domain.dto.LoginDto;
import top.yueqiao.yueblog.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author yueqiao
* @description 针对表【user】的数据库操作Service
* @createDate 2023-08-17 14:47:04
*/
public interface UserService extends IService<User> {

    Map<String, String> login(LoginDto loginDto);

}
