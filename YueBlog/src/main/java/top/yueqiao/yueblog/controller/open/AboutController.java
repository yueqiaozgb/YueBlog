package top.yueqiao.yueblog.controller.open;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.entity.About;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.service.AboutService;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/open/about")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AboutController extends BaseController {

    private final AboutService aboutService;

    @GetMapping
    public Result<About> getAbout() {
        return Result.success(aboutService.selectAbout());
    }

}
