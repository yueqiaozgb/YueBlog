package top.yueqiao.blog.service;

import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.SiteSetting;
import top.yueqiao.blog.domain.model.vo.DictTagVo;

/**
 * @author : yueqiao
 * @date : 2025/4/4 22:42
 */
public interface ISiteSettingService {

    PageResult<SiteSetting> selectPageSiteSettingList(SiteSetting siteSetting, PageQuery pageQuery);

    SiteSetting selectSiteSettingById(Integer id);

    int insertSiteSetting(SiteSetting siteSetting);

    int updateSiteSetting(SiteSetting siteSetting);

    int deleteSiteSettingByIds(Integer[] ids);

    PageResult<DictTagVo> selectSiteSettingType();

}
