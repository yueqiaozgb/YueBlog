package top.yueqiao.yueblog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录Dto对象
 *
 * @author yueqiao
 */
@Data
@NoArgsConstructor
public class LoginDto {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

}
