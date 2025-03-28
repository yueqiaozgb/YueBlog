package top.yueqiao.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.model.vo.BlogEditVo;
import top.yueqiao.blog.domain.model.vo.BlogListItemVo;

/**
 * @author : yueqiao
 * @date : 2025/3/23 21:22
 */
public interface IBlogService extends IService<Blog> {

    PageResult<BlogListItemVo> selectPageBlogList(Blog blog, PageQuery pageQuery);

    BlogEditVo selectBlogById(Integer id);

    int insertBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlogByIds(Integer[] ids);

}
