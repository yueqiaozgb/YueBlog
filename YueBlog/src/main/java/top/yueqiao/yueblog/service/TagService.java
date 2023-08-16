package top.yueqiao.yueblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.yueblog.domain.entity.Tag;

import java.util.List;

/**
* @author yueqiao
* @description 针对表【tag(标签表)】的数据库操作Service
* @createDate 2023-08-15 00:20:24
*/
public interface TagService extends IService<Tag> {



    List<Tag> selectTagList();

}
