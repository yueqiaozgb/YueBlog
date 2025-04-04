package top.yueqiao.blog.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author : yueqiao
 * @date : 2025/4/4 22:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictTagVo implements Serializable {
    @Serial
    private final static long serialVersionUID = 1L;
    private String label;
    private String value;
}
