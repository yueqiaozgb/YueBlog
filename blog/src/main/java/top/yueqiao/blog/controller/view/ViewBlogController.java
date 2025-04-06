package top.yueqiao.blog.controller.view;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.domain.AjaxResult;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.model.vo.BlogDetailVo;
import top.yueqiao.blog.domain.model.vo.BlogInfoVo;
import top.yueqiao.blog.domain.model.vo.BlogRandomVo;
import top.yueqiao.blog.service.IBlogService;

/**
 * @author : yueqiao
 * @date : 2025/4/4 15:52
 */
@RestController
@RequestMapping("/view/blog")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ViewBlogController {

    private final IBlogService blogService;

    @GetMapping("/random")
    public PageResult<BlogRandomVo> random() {
        return blogService.selectPageRandomBlogList();
    }

    @GetMapping("/list")
    public PageResult<BlogInfoVo> list(PageQuery pageQuery) {
        return blogService.selectPageBlogInfoVoList(pageQuery);
    }

    @GetMapping("/{id}")
    public AjaxResult<BlogDetailVo> select(@NotNull(message = "id不能为空") @PathVariable Integer id) {
        return AjaxResult.success(blogService.selectBlogDetailById(id));
    }

}
