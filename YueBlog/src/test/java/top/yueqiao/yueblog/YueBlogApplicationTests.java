package top.yueqiao.yueblog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.yueqiao.yueblog.mapper.SysUserMapper;

@SpringBootTest
class YueBlogApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void testMapper(){
        System.out.println(sysUserMapper.selectById(1));
    }

}
