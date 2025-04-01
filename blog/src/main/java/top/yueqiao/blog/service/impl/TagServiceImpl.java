package top.yueqiao.blog.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.BlogTag;
import top.yueqiao.blog.domain.entity.Tag;
import top.yueqiao.blog.exception.ServiceException;
import top.yueqiao.blog.mapper.BlogTagMapper;
import top.yueqiao.blog.mapper.TagMapper;
import top.yueqiao.blog.service.ITagService;

/**
 * @author : yueqiao
 * @date : 2025/4/1 23:21
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Resource
    private BlogTagMapper blogTagMapper;

    @Override
    public PageResult<Tag> selectPageTagList(Tag tag, PageQuery pageQuery) {
        LambdaQueryWrapper<Tag> lqw = new LambdaQueryWrapper<Tag>()
                .like(StrUtil.isNotBlank(tag.getName()), Tag::getName, tag.getName());
        Page<Tag> page = page(pageQuery.build(), lqw);
        return PageResult.build(page);
    }

    @Override
    public Tag selectTagById(Integer id) {
        return getById(id);
    }

    @Override
    public int insertTag(Tag tag) {
        return baseMapper.insert(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return baseMapper.updateById(tag);
    }

    @Override
    public int deleteTagByIds(Integer[] ids) {
        LambdaQueryWrapper<BlogTag> lqw = new LambdaQueryWrapper<BlogTag>()
                .in(BlogTag::getTagId, CollUtil.toList(ids));
        if (blogTagMapper.delete(lqw) > 0) {
            throw new ServiceException("存在博客标签关联,不可删除");
        }
        return baseMapper.deleteByIds(CollUtil.toList(ids));
    }

}
