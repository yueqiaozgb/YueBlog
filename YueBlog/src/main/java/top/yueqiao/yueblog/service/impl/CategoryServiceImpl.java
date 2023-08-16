package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.entity.Category;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;
import top.yueqiao.yueblog.service.CategoryService;
import top.yueqiao.yueblog.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static top.yueqiao.yueblog.constant.Constants.Page.PAGE_SIZE;

/**
* @author yueqiao
* @description 针对表【category(分类表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:19
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Override
    public List<Category> selectCategoryList() {
        return baseMapper.selectList(null);
    }

}




