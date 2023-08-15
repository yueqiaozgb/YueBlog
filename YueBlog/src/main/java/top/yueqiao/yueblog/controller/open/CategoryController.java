package top.yueqiao.yueblog.controller.open;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.domain.PageInfo;
import top.yueqiao.yueblog.domain.vo.BlogInfoVo;
import top.yueqiao.yueblog.service.CategoryService;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/open/category")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CategoryController extends BaseController {

    private final CategoryService categoryService;

    @GetMapping("/listByName")
    public PageInfo<BlogInfoVo> getTagList(@RequestParam String categoryName, @RequestParam(defaultValue = "1") Integer pageNum) {
        return categoryService.selectBlogInfoVoPageByCategoryName(categoryName, pageNum);
    }

}
