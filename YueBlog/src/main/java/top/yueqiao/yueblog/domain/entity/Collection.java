package top.yueqiao.yueblog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import top.yueqiao.yueblog.domain.BaseEntity;

import java.io.Serializable;

/**
 * 合集表
 *
 * @author yueqiao
 * @TableName collection
 */
@Data
@Accessors(chain = true)
@TableName(value ="collection")
@EqualsAndHashCode(callSuper = true)
public class Collection extends BaseEntity implements Serializable {

    /**
     * 合集id
     */
    @TableId(type = IdType.AUTO)
    private Integer collectionId;

    /**
     * 合集名称
     */
    private String collectionName;

    /**
     * 合集简介
     */
    private String collectionIntroduction;

}