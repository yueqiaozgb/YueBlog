package top.yueqiao.blog.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.blog.constant.RoleConstant;
import top.yueqiao.blog.controller.BaseController;
import top.yueqiao.blog.domain.AjaxResult;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Tag;
import top.yueqiao.blog.service.ITagService;

/**
 * @author : yueqiao
 * @date : 2025/4/1 23:19
 */
@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TagController extends BaseController {

    private final ITagService tagService;

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/list")
    public PageResult<Tag> list(Tag tag, PageQuery pageQuery) {
        return tagService.selectPageTagList(tag, pageQuery);
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/{id}")
    public AjaxResult<Tag> select(@NotNull(message = "id不能为空") @PathVariable Integer id) {
        return AjaxResult.success(tagService.selectTagById(id));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PostMapping
    public AjaxResult<Void> insert(@RequestBody Tag tag) {
        return toAjax(tagService.insertTag(tag));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PutMapping
    public AjaxResult<Void> update(@RequestBody Tag tag) {
        return toAjax(tagService.updateTag(tag));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> delete(@PathVariable Integer[] ids) {
        return toAjax(tagService.deleteTagByIds(ids));
    }

}
