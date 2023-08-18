package top.yueqiao.yueblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.entity.Tag;

/**
* @author yueqiao
* @description 针对表【tag(标签表)】的数据库操作Service
* @createDate 2023-08-15 00:20:24
*/
public interface TagService extends IService<Tag> {

    PageInfo<Tag> selectPageTagList(PageQuery pageQuery);

    int deleteTag(Long tagId);

}
