package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.PageQuery;
import top.yueqiao.yueblog.domain.entity.BlogTag;
import top.yueqiao.yueblog.domain.entity.Tag;
import top.yueqiao.yueblog.exception.ServiceException;
import top.yueqiao.yueblog.mapper.BlogTagMapper;
import top.yueqiao.yueblog.mapper.TagMapper;
import top.yueqiao.yueblog.service.TagService;

/**
* @author yueqiao
* @description 针对表【tag(标签表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:24
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService{

    @Autowired
    private BlogTagMapper blogTagMapper;

    @Override
    public PageInfo<Tag> selectPageTagList(PageQuery pageQuery) {
        IPage<Tag> tagPage = baseMapper.selectPage(pageQuery.build(), null);
        return PageInfo.build(tagPage);
    }

    @Override
    public int deleteTag(Long tagId) {
        LambdaQueryWrapper<BlogTag> lqw = new LambdaQueryWrapper<BlogTag>()
                .eq(BlogTag::getTagId, tagId);
        boolean exists = blogTagMapper.exists(lqw);
        if (exists) {
            throw new ServiceException("该标签下存在博客，不能删除");
        }
        return baseMapper.deleteById(tagId);
    }

}




