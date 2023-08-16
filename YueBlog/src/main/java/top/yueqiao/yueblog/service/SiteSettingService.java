package top.yueqiao.yueblog.service;

import top.yueqiao.yueblog.domain.entity.SiteSetting;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author yueqiao
* @description 针对表【site_setting】的数据库操作Service
* @createDate 2023-08-15 23:11:29
*/
public interface SiteSettingService extends IService<SiteSetting> {

    Map<String, Object> selectSiteInfo();

}
