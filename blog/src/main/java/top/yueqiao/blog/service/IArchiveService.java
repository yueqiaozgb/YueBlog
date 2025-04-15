package top.yueqiao.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.model.vo.BlogArchiveVo;

/**
 * @author yueqiao
 * @date 2025/04/15/11:37
 */
public interface IArchiveService extends IService<Blog> {

    PageResult<BlogArchiveVo> pageBlogArchiveVo();

}
