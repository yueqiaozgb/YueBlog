package top.yueqiao.yueblog.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yueqiao
 */
@Data
@TableName("blog_user")
public class BlogUser {

    @TableId
    private Long id;
    private String username;
    private String password;

}
