package top.yueqiao.yueblog.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class RandomBlogVo {

    /**
     * 博客id
     */
    @TableId(type = IdType.AUTO)
    private Long blogId;

    /**
     * 博客标题
     */
    private String blogTitle;

    /**
     * 博客封面
     */
    private String blogCover;

    /**
     * 创建时间
     */
    private Date createTime;

}
