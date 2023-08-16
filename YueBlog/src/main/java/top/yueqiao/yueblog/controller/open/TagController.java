package top.yueqiao.yueblog.controller.open;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yueqiao.yueblog.controller.BaseController;
import top.yueqiao.yueblog.service.TagService;

/**
 * @author yueqiao
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/open/tag")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TagController extends BaseController {

    private final TagService tagService;



}
