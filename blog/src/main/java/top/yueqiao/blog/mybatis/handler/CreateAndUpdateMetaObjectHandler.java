package top.yueqiao.blog.mybatis.handler;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import top.yueqiao.blog.domain.BaseEntity;
import top.yueqiao.blog.exception.ServiceException;

import java.time.LocalDateTime;

/**
 * @author yueqiao
 * @date 2025/03/28/16:47
 */
public class CreateAndUpdateMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity baseEntity) {
                LocalDateTime now = LocalDateTime.now();
                if (ObjectUtil.isNull(baseEntity.getCreateTime())) {
                    baseEntity.setCreateTime(now);
                }
                if (ObjectUtil.isNull(baseEntity.getUpdateTime())) {
                    baseEntity.setUpdateTime(now);
                }
            }
        } catch (Exception e) {
            throw new ServiceException("自动注入异常:" + e.getMessage());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity baseEntity) {
                if (ObjectUtil.isNull(baseEntity.getUpdateTime())) {
                    baseEntity.setUpdateTime(LocalDateTime.now());
                }
            }
        } catch (Exception e) {
            throw new ServiceException("自动注入异常:" + e.getMessage());
        }
    }

}
