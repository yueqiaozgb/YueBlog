package top.yueqiao.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.model.dto.BlogEditDto;
import top.yueqiao.blog.domain.model.vo.BlogEditVo;
import top.yueqiao.blog.domain.model.vo.BlogInfoVo;
import top.yueqiao.blog.domain.model.vo.BlogListItemVo;
import top.yueqiao.blog.domain.model.vo.BlogRandomVo;

/**
 * @author : yueqiao
 * @date : 2025/3/23 21:22
 */
public interface IBlogService extends IService<Blog> {

    PageResult<BlogListItemVo> selectPageBlogList(Blog blog, PageQuery pageQuery);

    BlogEditVo selectBlogById(Integer id);

    int insertBlog(BlogEditDto blog);

    int updateBlog(BlogEditDto blog);

    int deleteBlogByIds(Integer[] ids);

    PageResult<BlogRandomVo> selectPageRandomBlogList();

    PageResult<BlogInfoVo> selectPageBlogInfoVoList(PageQuery pageQuery);

}
