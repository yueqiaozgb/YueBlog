package top.yueqiao.yueblog.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.entity.About;
import top.yueqiao.yueblog.service.AboutService;
import top.yueqiao.yueblog.validate.UpdateGroup;

import static top.yueqiao.yueblog.constant.Constants.Role.ROLE_ADMIN;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/about")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AboutAdminController extends BaseController {

    private final AboutService aboutService;

    @GetMapping
    public Result<About> getAbout() {
        return Result.success(aboutService.selectAbout());
    }

    @PutMapping
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> updateAbout(@Validated(UpdateGroup.class) @RequestBody About about) {
        return toAjax(aboutService.updateById(about));
    }


}
