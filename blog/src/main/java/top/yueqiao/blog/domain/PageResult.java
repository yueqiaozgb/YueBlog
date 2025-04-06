package top.yueqiao.blog.domain;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.yueqiao.blog.enums.ReturnCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/28/11:38
 */
@Data
@NoArgsConstructor
public class PageResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private List<T> data;

    private Long total;

    public PageResult(List<T> data, Long total) {
        this.code = ReturnCode.RC200.getCode();
        this.msg = ReturnCode.RC200.getMsg();
        this.data = data;
        this.total = total;
    }

    public static <T> PageResult<T> build(List<T> data) {
        return new PageResult<>(data, (long) data.size());
    }

    public static <T> PageResult<T> build(IPage<T> page) {
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    public static <T> PageResult<T> build(List<T> data, Long total) {
        return new PageResult<>(data, total);
    }

}
