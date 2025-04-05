package top.yueqiao.blog.controller.view;

/**
 * @author : yueqiao
 * @date : 2025/4/5 18:59
 */

import cn.dev33.satoken.annotation.SaCheckRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.constant.RoleConstant;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.SiteSetting;
import top.yueqiao.blog.service.ISiteSettingService;

/**
 * @author : yueqiao
 * @date : 2025/4/4 22:43
 */
@RestController
@RequestMapping("/view/site-setting")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ViewSiteSettingController {

    private final ISiteSettingService siteSettingService;

    @SaCheckRole(RoleConstant.ADMIN)
    @GetMapping("/list")
    public PageResult<SiteSetting> list(SiteSetting siteSetting, PageQuery pageQuery) {
        return siteSettingService.selectPageSiteSettingList(siteSetting, pageQuery);
    }

}
