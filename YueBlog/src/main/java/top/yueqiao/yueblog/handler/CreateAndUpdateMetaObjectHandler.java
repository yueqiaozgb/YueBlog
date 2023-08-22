package top.yueqiao.yueblog.handler;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import top.yueqiao.yueblog.domain.BaseEntity;
import top.yueqiao.yueblog.domain.entity.User;
import top.yueqiao.yueblog.exception.ServiceException;
import top.yueqiao.yueblog.util.LoginUtils;

import java.util.Date;

/**
 * MP注入处理器
 *
 * @author yueqiao
 */
@Slf4j
public class CreateAndUpdateMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity baseEntity) {
                Date current = new Date();
                // 创建时间填充
                if (ObjectUtil.isNull(baseEntity.getCreateTime())) {
                    baseEntity.setCreateTime(current);
                }
                // 更新时间填充
                if (ObjectUtil.isNull(baseEntity.getUpdateTime())) {
                    baseEntity.setUpdateTime(current);
                }
                String username = getLoginUsername();
                // 创建人填充
                if (StrUtil.isNotBlank(username) && StrUtil.isBlank(baseEntity.getCreateBy())) {
                    baseEntity.setCreateBy(username);
                }
                // 更新人填充
                if (StrUtil.isNotBlank(username) && StrUtil.isBlank(baseEntity.getUpdateBy())) {
                    baseEntity.setUpdateBy(username);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("自动注入异常 => " + e.getMessage(), HttpStatus.HTTP_UNAUTHORIZED);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity baseEntity) {
                Date current = new Date();
                // 更新时间填充
                if (ObjectUtil.isNull(baseEntity.getUpdateTime())) {
                    baseEntity.setUpdateTime(current);
                }
                String username = getLoginUsername();
                // 更新人填充
                if (StrUtil.isNotBlank(username) && StrUtil.isBlank(baseEntity.getUpdateBy())) {
                    baseEntity.setUpdateBy(username);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("自动注入异常 => " + e.getMessage(), HttpStatus.HTTP_UNAUTHORIZED);
        }
    }

    /**
     * 获取登录用户名
     */
    private String getLoginUsername() {
        User loginUser = LoginUtils.getLoginUser();
        return loginUser.getUsername();
    }

}
