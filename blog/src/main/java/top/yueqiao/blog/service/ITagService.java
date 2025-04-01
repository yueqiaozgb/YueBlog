package top.yueqiao.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Tag;

/**
 * @author : yueqiao
 * @date : 2025/4/1 23:21
 */
public interface ITagService extends IService<Tag> {

    PageResult<Tag> selectPageTagList(Tag tag, PageQuery pageQuery);

    Tag selectTagById(Integer id);

    int insertTag(Tag tag);

    int updateTag(Tag tag);

    int deleteTagByIds(Integer[] ids);

}
