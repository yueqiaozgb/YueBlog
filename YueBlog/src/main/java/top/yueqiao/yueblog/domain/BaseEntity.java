package top.yueqiao.yueblog.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yueqiao
 */
@Data
public class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    @Size(max= 64,message="编码长度不能超过64")
    @Length(max= 64,message="编码长度不能超过64")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新者
     */
    @Size(max= 64,message="编码长度不能超过64")
    @Length(max= 64,message="编码长度不能超过64")
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

}
