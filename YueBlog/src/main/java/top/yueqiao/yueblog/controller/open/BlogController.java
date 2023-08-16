package top.yueqiao.yueblog.controller.open;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.vo.BlogDetailVo;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;
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

    @GetMapping("/listByQuery")
    public Result<List<SearchBlogVo>> getBlogList(String query) {
        return Result.success(blogService.selectSearchBlogVoList(query));
    }

    @GetMapping("/archives")
    public Result<Map<String, Object>> getArchives() {
        return Result.success(blogService.selectArchiveBlogVoList());
    }

    @GetMapping("/list")
    public PageInfo<BlogInfoVo> getBlogList(@RequestParam(defaultValue = "1") Integer pageNum) {
        return blogService.selectBlogInfoVoPage(pageNum);
    }

    @GetMapping("/listByTagName")
    public PageInfo<BlogInfoVo> getBlogListByTagName(@RequestParam String tagName, @RequestParam(defaultValue = "1") Integer pageNum) {
        return blogService.selectBlogInfoVoPageByTagName(tagName, pageNum);
    }

    @GetMapping("/listByCategoryName")
    public PageInfo<BlogInfoVo> getBlogListByCategoryName(@RequestParam String categoryName, @RequestParam(defaultValue = "1") Integer pageNum) {
        return blogService.selectBlogInfoVoPageByCategoryName(categoryName, pageNum);
    }

}
