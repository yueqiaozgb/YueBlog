package top.yueqiao.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.blog.entity.User;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:17
 */
public interface ILoginService extends IService<User> {

    String login(String username, String password);

}
