package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.entity.About;
import top.yueqiao.yueblog.service.AboutService;
import top.yueqiao.yueblog.mapper.AboutMapper;
import org.springframework.stereotype.Service;

/**
* @author yueqiao
* @description 针对表【about(关于表)】的数据库操作Service实现
* @createDate 2023-08-15 16:26:24
*/
@Service
public class AboutServiceImpl extends ServiceImpl<AboutMapper, About> implements AboutService{

    private final static Long ABOUT_ID = 1L;

    @Override
    public About selectAbout() {
        return baseMapper.selectById(ABOUT_ID);
    }

}




