package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import top.yueqiao.yueblog.domain.entity.About;
import top.yueqiao.yueblog.service.AboutService;
import top.yueqiao.yueblog.mapper.AboutMapper;
import org.springframework.stereotype.Service;
import top.yueqiao.yueblog.util.MarkdownUtils;

/**
* @author yueqiao
* @description 针对表【about(关于表)】的数据库操作Service实现
* @createDate 2023-08-15 16:26:24
*/
@Service
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About> implements AboutService{

    private final static Long ABOUT_ID = 1L;

    @Override
    @Cacheable(value = "aboutCache", key = "'about'")
    public About selectAbout() {
        About about = baseMapper.selectById(ABOUT_ID);
        about.setAboutContent(MarkdownUtils.markdownToHtmlExtensions(about.getAboutContent()));
        return about;
    }

}




