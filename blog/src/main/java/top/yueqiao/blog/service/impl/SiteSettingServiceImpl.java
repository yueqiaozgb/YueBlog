package top.yueqiao.blog.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.SiteSetting;
import top.yueqiao.blog.domain.model.vo.DictTagVo;
import top.yueqiao.blog.enums.SiteSettingType;
import top.yueqiao.blog.mapper.SiteSettingMapper;
import top.yueqiao.blog.service.ISiteSettingService;

import java.util.Arrays;
import java.util.List;

/**
 * @author : yueqiao
 * @date : 2025/4/4 22:42
 */
@Service
public class SiteSettingServiceImpl extends ServiceImpl<SiteSettingMapper, SiteSetting> implements ISiteSettingService {

    @Override
    public PageResult<SiteSetting> selectPageSiteSettingList(SiteSetting siteSetting, PageQuery pageQuery) {
        LambdaQueryWrapper<SiteSetting> lqw = new LambdaQueryWrapper<SiteSetting>()
                .eq(StrUtil.isNotBlank(siteSetting.getType()), SiteSetting::getType, siteSetting.getType())
                .like(StrUtil.isNotBlank(siteSetting.getName()), SiteSetting::getName, siteSetting.getName());
        Page<SiteSetting> page = page(pageQuery.build(), lqw);
        return PageResult.build(page);
    }

    @Override
    public SiteSetting selectSiteSettingById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int insertSiteSetting(SiteSetting siteSetting) {
        return baseMapper.insert(siteSetting);
    }

    @Override
    public int updateSiteSetting(SiteSetting siteSetting) {
        return baseMapper.updateById(siteSetting);
    }

    @Override
    public int deleteSiteSettingByIds(Integer[] ids) {
        return baseMapper.deleteByIds(CollUtil.toList(ids));
    }

    @Override
    public PageResult<DictTagVo> selectSiteSettingType() {
        List<DictTagVo> dictTagVoList = Arrays.stream(SiteSettingType.values())
                .map(type -> new DictTagVo(type.getLabel(), type.getValue()))
                .toList();
        return PageResult.build(dictTagVoList);
    }

}
