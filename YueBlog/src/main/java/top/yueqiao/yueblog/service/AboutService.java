package top.yueqiao.yueblog.service;

import top.yueqiao.yueblog.domain.entity.About;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yueqiao
* @description 针对表【about(关于表)】的数据库操作Service
* @createDate 2023-08-15 16:26:24
*/
public interface AboutService extends IService<About> {

    About selectAbout();

}
