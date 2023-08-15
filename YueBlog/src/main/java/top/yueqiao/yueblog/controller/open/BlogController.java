package top.yueqiao.yueblog.controller.open;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.vo.BlogDetailVo;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.vo.SearchBlogVo;
import top.yueqiao.yueblog.service.BlogService;

import java.util.List;
import java.util.Map;

/**
 * 博客控制器
 *
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/open/blog")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BlogController extends BaseController {

    private final BlogService blogService;

    @GetMapping("/{id}")
    public Result<BlogDetailVo> getBlog(@PathVariable @NotNull(message = "博客id不能为空") Long id) {
        return Result.success(blogService.selectBlogDetailVoById(id));
    }

    @GetMapping("/list")
    public Result<List<SearchBlogVo>> getBlogList(String query) {
        return Result.success(blogService.selectSearchBlogVoList(query));
    }

    @GetMapping("/archives")
    public Result<Map<String, Object>> getArchives() {
        return Result.success(blogService.selectArchiveBlogVoList());
    }

}
