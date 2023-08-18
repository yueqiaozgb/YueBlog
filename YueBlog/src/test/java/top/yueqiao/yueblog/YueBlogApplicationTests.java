package top.yueqiao.yueblog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.yueqiao.yueblog.domain.dto.BlogDto;
import top.yueqiao.yueblog.mapper.BlogMapper;
import top.yueqiao.yueblog.mapstruct.BlogConvertor;

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
//        List<SearchBlogVo> searchBlogVos = blogMapper.selectSearchBlogVoList("测");
//        searchBlogVos.forEach(System.out::println);
    }

    @Test
    void testFastJson() {
//        Blog blog = blogMapper.selectById(2L);
//        String json = JSON.toJSONString(blog);
//        System.out.println(json);
    }

    @Test
    void testMapStruct() {
        BlogDto blogDto = new BlogDto();
        blogDto.setBlogIntroduction("1223");
        System.out.println(BlogConvertor.INSTANCE.blogDto2Blog(blogDto));
    }

    @Test
    void testBool() {
        boolean b = true;
    }


}
