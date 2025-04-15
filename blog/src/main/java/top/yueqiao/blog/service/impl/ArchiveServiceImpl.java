package top.yueqiao.blog.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.model.vo.BlogArchiveVo;
import top.yueqiao.blog.mapper.BlogMapper;
import top.yueqiao.blog.service.IArchiveService;

/**
 * @author yueqiao
 * @date 2025/04/15/11:37
 */
@Service
public class ArchiveServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IArchiveService {

    @Override
    public PageResult<BlogArchiveVo> pageBlogArchiveVo() {
        PageQuery pageQuery = new PageQuery();
        Page<BlogArchiveVo> page = baseMapper.pageBlogArchiveVo(pageQuery.build());
        return PageResult.build(page);
    }

}
