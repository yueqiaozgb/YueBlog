package top.yueqiao.yueblog.controller.open;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.yueblog.domain.Result;
import top.yueqiao.yueblog.domain.entity.Category;
import top.yueqiao.yueblog.domain.entity.Tag;
import top.yueqiao.yueblog.domain.vo.BlogPreviewVo;
import top.yueqiao.yueblog.service.BlogService;
import top.yueqiao.yueblog.service.CategoryService;
import top.yueqiao.yueblog.service.SiteSettingService;
import top.yueqiao.yueblog.service.TagService;

import java.util.List;
import java.util.Map;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/open/site")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SiteSettingController {

    private final SiteSettingService siteSettingService;

    private final BlogService blogService;

    private final CategoryService categoryService;

    private final TagService tagService;

    @GetMapping
    public Result<Map<String, Object>> getSiteSetting() {
        Map<String, Object> map = siteSettingService.selectSiteInfo();
        List<BlogPreviewVo> newBlogList = blogService.selectNewBlogVoList();
        List<Category> categoryList = categoryService.selectCategoryList();
        List<Tag> tagList = tagService.selectTagList();
        List<BlogPreviewVo> randomBlogList = blogService.selectRandomBlogList();
        map.put("newBlogList", newBlogList);
        map.put("categoryList", categoryList);
        map.put("tagList", tagList);
        map.put("randomBlogList", randomBlogList);
        return Result.success("请求成功", map);
    }

}
