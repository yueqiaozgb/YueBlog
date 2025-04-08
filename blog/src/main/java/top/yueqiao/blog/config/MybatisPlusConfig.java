package top.yueqiao.blog.config;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.yueqiao.blog.mybatis.handler.CreateAndUpdateMetaObjectHandler;
import top.yueqiao.blog.mybatis.injector.InsertBatchSqlInjector;

/**
 * @author : yueqiao
 * @date : 2025/3/23 21:24
 */

@Configuration
public class MybatisPlusConfig {

    /**
     * 创建分页代理对象并添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(true);
        paginationInnerInterceptor.setMaxLimit(100L);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }

    /**
     * MyBatis-Plus 的元对象处理器，自动生成创建时间、修改时间
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new CreateAndUpdateMetaObjectHandler();
    }

    /**
     * MyBatis-Plus 的批量插入处理器, 只在MySQL环境使用
     */
    @Bean
    public InsertBatchSqlInjector easySqlInjector() {
        return new InsertBatchSqlInjector();
    }

    /**
     * MyBatis-Plus 的全局配置新增批量插入处理器
     */
    @Bean
    public GlobalConfig globalConfig(@Qualifier("easySqlInjector") ISqlInjector easySqlInjector) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setSqlInjector(easySqlInjector);
        return globalConfig;
    }

}
