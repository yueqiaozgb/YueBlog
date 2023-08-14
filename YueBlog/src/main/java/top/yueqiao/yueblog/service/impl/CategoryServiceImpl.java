package top.yueqiao.yueblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yueqiao.yueblog.domain.entity.Category;
import top.yueqiao.yueblog.service.CategoryService;
import top.yueqiao.yueblog.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author yueqiao
* @description 针对表【category(分类表)】的数据库操作Service实现
* @createDate 2023-08-15 00:20:19
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




