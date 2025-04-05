package top.yueqiao.blog.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.domain.PageQuery;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.entity.Tag;
import top.yueqiao.blog.service.ITagService;

/**
 * @author : yueqiao
 * @date : 2025/4/5 23:42
 */
@RestController
@RequestMapping("/view/tag")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ViewTagController {

    private final ITagService tagService;

    @GetMapping("/list")
    public PageResult<Tag> list(Tag tag, PageQuery pageQuery) {
        return tagService.selectPageTagList(tag, pageQuery);
    }

}
