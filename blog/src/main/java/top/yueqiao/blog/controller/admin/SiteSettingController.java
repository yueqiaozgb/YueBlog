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
import top.yueqiao.blog.domain.entity.SiteSetting;
import top.yueqiao.blog.domain.model.vo.DictTagVo;
import top.yueqiao.blog.service.ISiteSettingService;

/**
 * @author : yueqiao
 * @date : 2025/4/4 22:43
 */
@RestController
@RequestMapping("/site-setting")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SiteSettingController extends BaseController {

    private final ISiteSettingService siteSettingService;

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/list")
    public PageResult<SiteSetting> list(SiteSetting siteSetting, PageQuery pageQuery) {
        return siteSettingService.selectPageSiteSettingList(siteSetting, pageQuery);
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/{id}")
    public AjaxResult<SiteSetting> select(@NotNull(message = "id不能为空") @PathVariable Integer id) {
        return AjaxResult.success(siteSettingService.selectSiteSettingById(id));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PostMapping
    public AjaxResult<Void> insert(@RequestBody SiteSetting siteSetting) {
        return toAjax(siteSettingService.insertSiteSetting(siteSetting));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @PutMapping
    public AjaxResult<Void> update(@RequestBody SiteSetting siteSetting) {
        return toAjax(siteSettingService.updateSiteSetting(siteSetting));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @DeleteMapping("/{ids}")
    public AjaxResult<Void> delete(@PathVariable Integer[] ids) {
        return toAjax(siteSettingService.deleteSiteSettingByIds(ids));
    }

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/type")
    public PageResult<DictTagVo> type() {
        return siteSettingService.selectSiteSettingType();
    }

}
