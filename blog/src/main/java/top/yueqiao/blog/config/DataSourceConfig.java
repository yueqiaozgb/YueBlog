package top.yueqiao.blog.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author yueqiao
 * @date 2025/03/13/18:37
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Bean
    public ApplicationRunner runner(DataSource dataSource) {
        return args -> {
            log.info("dataSource: {}", dataSource);
            Connection connection = dataSource.getConnection();
            log.info("connection: {}", connection);
        };
    }

}
