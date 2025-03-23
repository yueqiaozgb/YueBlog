package top.yueqiao.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.blog.domain.entity.Blog;

/**
 * @author : yueqiao
 * @date : 2025/3/23 21:22
 */
public interface IBlogService extends IService<Blog> {

    IPage<Blog> listBlog(Integer pageNum, Integer pageSize);

}
