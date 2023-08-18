package top.yueqiao.yueblog.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.entity.Tag;
import top.yueqiao.yueblog.service.TagService;

import java.util.List;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/tag")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TagAdminController {

    private final TagService tagService;

    @GetMapping("/list")
    public Result<List<Tag>> list() {
        return Result.success(tagService.list());
    }

}
