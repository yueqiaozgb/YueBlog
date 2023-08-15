package top.yueqiao.yueblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.yueqiao.yueblog.domain.entity.Tag;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;

/**
 * 针对表【tag(标签表)】的数据库操作Mapper
 *
 * @author yueqiao
 */
public interface TagMapper extends BaseMapper<Tag> {

    IPage<BlogInfoVo> selectBlogInfoVoPageByTagName(IPage<BlogInfoVo> page, String tagName);

}




