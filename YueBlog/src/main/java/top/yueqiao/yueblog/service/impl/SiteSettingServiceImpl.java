package top.yueqiao.yueblog.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yueqiao.yueblog.domain.entity.SiteSetting;
import top.yueqiao.yueblog.domain.vo.BadgeVo;
import top.yueqiao.yueblog.domain.vo.CopyrightVo;
import top.yueqiao.yueblog.domain.vo.FavoriteVo;
import top.yueqiao.yueblog.domain.vo.IntroductionVo;
import top.yueqiao.yueblog.exception.ServiceException;
import top.yueqiao.yueblog.mapper.SiteSettingMapper;
import top.yueqiao.yueblog.service.SiteSettingService;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static top.yueqiao.yueblog.constant.Constants.Flag.INTEGER_SUCCESS;
import static top.yueqiao.yueblog.constant.Constants.SiteSetting.*;

/**
* @author yueqiao
* @description 针对表【site_setting】的数据库操作Service实现
* @createDate 2023-08-15 23:11:29
*/
@Service
@Transactional
public class SiteSettingServiceImpl extends ServiceImpl<SiteSettingMapper, SiteSetting> implements SiteSettingService{

    private static final Pattern PATTERN = Pattern.compile("\"(.*?)\"");

    @Override
    public Map<String, Object> selectSiteInfo() {
        List<SiteSetting> siteSettings = baseMapper.selectList(null);
        Map<String, Object> siteInfo = new HashMap<>(2);
        List<BadgeVo> badges = new ArrayList<>();
        IntroductionVo introduction = new IntroductionVo();
        List<FavoriteVo> favorites = new ArrayList<>();
        List<String> rollTexts = new ArrayList<>();
        for (SiteSetting s : siteSettings) {
            switch (s.getType()) {
                case 1:
                    if (COPYRIGHT.equals(s.getSettingKey())) {
                        CopyrightVo copyright = JSON.parseObject(s.getValue(), CopyrightVo.class);
                        siteInfo.put(s.getSettingKey(), copyright);
                    } else {
                        siteInfo.put(s.getSettingKey(), s.getValue());
                    }
                    break;
                case 2:
                    switch (s.getSettingKey()) {
                        case AVATAR:
                            introduction.setAvatar(s.getValue());
                            break;
                        case NAME:
                            introduction.setName(s.getValue());
                            break;
                        case GITHUB:
                            introduction.setGithub(s.getValue());
                            break;
                        case QQ:
                            introduction.setQq(s.getValue());
                            break;
                        case BILIBILI:
                            introduction.setBilibili(s.getValue());
                            break;
                        case NETEASE:
                            introduction.setNetease(s.getValue());
                            break;
                        case EMAIL:
                            introduction.setEmail(s.getValue());
                            break;
                        case FAVORITE:
                            FavoriteVo favorite = JSON.parseObject(s.getValue(), FavoriteVo.class);
                            favorites.add(favorite);
                            break;
                        case ROLL_TEXT:
                            Matcher m = PATTERN.matcher(s.getValue());
                            while (m.find()) {
                                rollTexts.add(m.group(1));
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    BadgeVo badge = JSON.parseObject(s.getValue(), BadgeVo.class);
                    badges.add(badge);
                    break;
                default:
                    break;
            }
        }
        introduction.setFavorites(favorites);
        introduction.setRollText(rollTexts);
        Map<String, Object> map = new HashMap<>(8);
        map.put("introduction", introduction);
        map.put("siteInfo", siteInfo);
        map.put("badges", badges);
        return map;
    }

    @Override
    @Cacheable(value = "siteSettingCache", key = "'siteSetting'")
    public Map<String, List<SiteSetting>> selectSiteSettingMap() {
        List<SiteSetting> siteSettings = baseMapper.selectList(null);
        List<SiteSetting> type1 = new ArrayList<>();
        List<SiteSetting> type2 = new ArrayList<>();
        List<SiteSetting> type3 = new ArrayList<>();
        siteSettings.forEach(s -> {
            switch (s.getType()) {
                case 1 -> type1.add(s);
                case 2 -> type2.add(s);
                case 3 -> type3.add(s);
                default -> {
                }
            }
        });
        Map<String, List<SiteSetting>> map = new HashMap<>(8);
        map.put("type1", type1);
        map.put("type2", type2);
        map.put("type3", type3);
        return map;
    }

    @Override
    @CacheEvict(value = "siteSettingCache", key = "'siteSetting'")
    public boolean updateSiteSetting(List<LinkedHashMap> siteSettings, List<Integer> deleteIds) {
        if (ObjectUtil.isNull(deleteIds)) {
            int rows = baseMapper.deleteBatchIds(deleteIds);
            if (!ObjectUtil.equals(rows, deleteIds.size())) {
                throw new ServiceException("删除配置失败");
            }
        }
        for (LinkedHashMap s : siteSettings) {
            SiteSetting setting = JSON.parseObject(JSON.toJSONString(s), SiteSetting.class);
            if (setting.getId() != null) {
                int update = baseMapper.updateById(setting);
                if (!ObjectUtil.equals(update, INTEGER_SUCCESS)) {
                    throw new ServiceException("修改配置失败");
                }
            } else {
                int insert = baseMapper.insert(setting);
                if (!ObjectUtil.equals(insert, INTEGER_SUCCESS)) {
                    throw new ServiceException("添加配置失败");
                }
            }
        }
        return true;
    }

}




