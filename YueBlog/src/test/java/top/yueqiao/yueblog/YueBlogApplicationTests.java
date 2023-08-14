package top.yueqiao.yueblog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.mapper.BlogMapper;

@SpringBootTest
class YueBlogApplicationTests {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void testBlogMapper() {
        Blog blog = blogMapper.selectById(1L);
        System.out.println(blog);
    }


}
