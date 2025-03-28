package top.yueqiao.blog.domain;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author yueqiao
 * @date 2025/03/28/11:53
 */
@Data
public class PageQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private final static Integer DEFAULT_PAGE_NUM = 1;

    private final static Integer DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;

    public <T> Page<T> build() {
        Integer pageNum = ObjectUtil.defaultIfNull(this.pageNum, DEFAULT_PAGE_NUM);
        Integer pageSize = ObjectUtil.defaultIfNull(this.pageSize, DEFAULT_PAGE_SIZE);
        return new Page<>(pageNum, pageSize);
    }

}
