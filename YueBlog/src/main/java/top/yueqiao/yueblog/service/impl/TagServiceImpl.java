package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.entity.Tag;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;
import top.yueqiao.yueblog.mapper.TagMapper;
import top.yueqiao.yueblog.service.TagService;

import static top.yueqiao.yueblog.constant.Constants.Page.PAGE_SIZE;

/**
* @author yueqiao
* @description 针对表【tag(标签表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:24
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService{

    //常量

    @Override
    public PageInfo<BlogInfoVo> selectBlogInfoVoPageByTagName(String tagName, Integer pageNum) {
        IPage<BlogInfoVo> page = new Page<>(pageNum, PAGE_SIZE);
        IPage<BlogInfoVo> result = baseMapper.selectBlogInfoVoPageByTagName(page, tagName);
        return PageInfo.build(result);
    }

}




