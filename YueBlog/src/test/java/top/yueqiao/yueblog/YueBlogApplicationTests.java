package top.yueqiao.yueblog;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.yueqiao.yueblog.domain.BlogUser;
import top.yueqiao.yueblog.mapper.BlogUserMapper;

@SpringBootTest
class YueBlogApplicationTests {

    @Autowired
    private BlogUserMapper blogUserMapper;

    @Test
    void contextLoads() {
    }

    /**
     * 测试分页插件
     */
    @Test
    public void testMybatisPage(){
        IPage<BlogUser> page = new Page<>(2, 1);
        IPage<BlogUser> blogUserIPage = blogUserMapper.selectPage(page, null);
        System.out.println(blogUserIPage.getRecords());
    }

}
