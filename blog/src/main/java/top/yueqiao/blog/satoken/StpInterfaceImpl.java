package top.yueqiao.blog.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Component;
import top.yueqiao.blog.model.bo.UserBo;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/11/14:40
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        UserBo userBo = (UserBo) StpUtil.getSession().get("user");
        return userBo.getPermissionList();
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        UserBo userBo = (UserBo) StpUtil.getSession().get("user");
        return userBo.getRoleList();
    }

}
