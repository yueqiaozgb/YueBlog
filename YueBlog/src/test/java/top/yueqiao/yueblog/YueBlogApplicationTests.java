package top.yueqiao.yueblog;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.yueqiao.yueblog.domain.entity.Blog;
import top.yueqiao.yueblog.domain.vo.SearchBlogVo;
import top.yueqiao.yueblog.mapper.BlogMapper;

import java.util.List;

@SpringBootTest
class YueBlogApplicationTests {

    @Autowired
    private BlogMapper blogMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void testBlogMapper() {
//        Blog blog1 = new Blog();
//        blog1
//                .setBlogTitle("计算")
//                .setBlogContent("是全球的")
//                .setBlogWords(100L)
//                .setReadTime(2L);
//        blogMapper.insert(blog1);
//        Blog blog = blogMapper.selectById(2L);
//        System.out.println(blog);
//        BlogDetailVo blogDetailVo = blogMapper.selectBlogVoById(1L);
//        System.out.println(blogDetailVo);
        List<SearchBlogVo> searchBlogVos = blogMapper.selectSearchBlogVoList("测");
        searchBlogVos.forEach(System.out::println);
    }

    @Test
    void testFastJson(){
        Blog blog = blogMapper.selectById(2L);
        String json = JSON.toJSONString(blog);
        System.out.println(json);
    }


}
