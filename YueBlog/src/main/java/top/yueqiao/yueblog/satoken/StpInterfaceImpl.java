package top.yueqiao.yueblog.satoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpStatus;
import org.springframework.stereotype.Component;
import top.yueqiao.yueblog.domain.entity.User;
import top.yueqiao.yueblog.exception.ServiceException;
import top.yueqiao.yueblog.util.LoginUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * sa-token授权
 *
 * @author yueqiao
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return new ArrayList<>();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        User loginUser = LoginUtils.getLoginUser();
        if (ObjectUtil.isNull(loginUser)) {
            throw new ServiceException("用户未登录", HttpStatus.HTTP_UNAUTHORIZED);
        }
        List<String> roleList = new ArrayList<>();
        roleList.add(loginUser.getRoleKey());
        return roleList;
    }

}
