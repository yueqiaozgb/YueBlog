package top.yueqiao.blog.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.blog.domain.PageResult;
import top.yueqiao.blog.domain.model.vo.BlogArchiveVo;
import top.yueqiao.blog.service.IArchiveService;

/**
 * @author yueqiao
 * @date 2025/04/15/11:35
 */
@RestController
@RequestMapping("/view/archive")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ViewArchiveController {

    private final IArchiveService archiveService;

    @GetMapping("/list")
    public PageResult<BlogArchiveVo> list() {
        return archiveService.pageBlogArchiveVo();
    }

}
