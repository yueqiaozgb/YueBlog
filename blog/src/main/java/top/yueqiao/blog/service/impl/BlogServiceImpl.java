package top.yueqiao.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.mapper.BlogMapper;
import top.yueqiao.blog.service.IBlogService;

/**
 * @author : yueqiao
 * @date : 2025/3/26 0:04
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Override
    public IPage<Blog> listBlog(Integer pageNum, Integer pageSize) {
        IPage<Blog> page = new Page<>(pageNum, pageSize);
        IPage<Blog> blogPage = baseMapper.selectPage(page, null);
        if (blogPage.getTotal() > 0) {
            return blogPage;
        }
        return null;
    }

}
