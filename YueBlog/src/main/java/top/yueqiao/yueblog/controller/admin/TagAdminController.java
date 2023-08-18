package top.yueqiao.yueblog.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.entity.Tag;
import top.yueqiao.yueblog.service.TagService;
import top.yueqiao.yueblog.validate.InsertGroup;
import top.yueqiao.yueblog.validate.UpdateGroup;

import java.util.List;

import static top.yueqiao.yueblog.constant.Constants.Role.ROLE_ADMIN;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/tag")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TagAdminController extends BaseController {

    private final TagService tagService;

    @GetMapping("/list")
    public Result<List<Tag>> list() {
        return Result.success(tagService.list());
    }

    @GetMapping("/listByQuery")
    public PageInfo<Tag> listByQuery(PageQuery pageQuery) {
        return tagService.selectPageTagList(pageQuery);
    }

    @PostMapping
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> insert(@Validated(InsertGroup.class) @RequestBody Tag tag) {
        return toAjax(tagService.save(tag));
    }

    @PutMapping
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> updateTag(@Validated(UpdateGroup.class) @RequestBody Tag tag) {
        return toAjax(tagService.updateById(tag));
    }

    @DeleteMapping("/{id}")
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> deleteTag(@PathVariable Long id) {
        return toAjax(tagService.deleteTag(id));
    }

}
