package top.yueqiao.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import top.yueqiao.blog.enums.ReturnCode;

/**
 * @author : yueqiao
 * @date : 2025/3/11 23:22
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceException extends RuntimeException {

    private Integer code;

    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ServiceException(String msg) {
        super(msg);
        this.code = ReturnCode.RC4001.getCode();
    }

}
