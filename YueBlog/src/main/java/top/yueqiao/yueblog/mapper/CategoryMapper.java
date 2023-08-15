package top.yueqiao.yueblog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.yueqiao.yueblog.domain.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;

/**
 * 针对表【category(分类表)】的数据库操作Mapper
 *
 * @author yueqiao
 */
public interface CategoryMapper extends BaseMapper<Category> {

    IPage<BlogInfoVo> selectBlogInfoVoPageByCategoryName(IPage<BlogInfoVo> page, String categoryName);

}




