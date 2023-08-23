package top.yueqiao.yueblog.controller.admin;

import cn.dev33.satoken.annotation.SaCheckRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.entity.SiteSetting;
import top.yueqiao.yueblog.service.SiteSettingService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static top.yueqiao.yueblog.constant.Constants.Role.ROLE_ADMIN;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/admin/site")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SiteSettingAdminController extends BaseController {

    private final SiteSettingService siteSettingService;

    @GetMapping
    public Result<Map<String, List<SiteSetting>>> getSiteSetting() {
        return Result.success(siteSettingService.selectSiteSettingMap());
    }

    @PostMapping
    @SaCheckRole(ROLE_ADMIN)
    public Result<Void> updateSiteSetting(@RequestBody Map<String, Object> map) {
        List<LinkedHashMap> siteSettings = (List<LinkedHashMap>) map.get("settings");
        List<Integer> deleteIds = (List<Integer>) map.get("deleteIds");
        return toAjax(siteSettingService.updateSiteSetting(siteSettings, deleteIds));
    }

}
