package top.yueqiao.yueblog.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import top.yueqiao.yueblog.domain.dto.BlogDto;
import top.yueqiao.yueblog.domain.entity.Blog;

/**
 * @author yueqiao
 */
@Mapper
public interface BlogConvertor {

    BlogConvertor INSTANCE = Mappers.getMapper(BlogConvertor.class);

    /**
     * BlogDto -> Blog
     */
    @Mappings({
            @Mapping(target = "updateBy", ignore = true),
            @Mapping(target = "createTime", ignore = true),
            @Mapping(target = "createBy", ignore = true),
            @Mapping(target = "updateTime", ignore = true),
            @Mapping(target = "tags", ignore = true),
            @Mapping(target = "category", ignore = true)
    })
    Blog blogDto2Blog(BlogDto blogDto);

}
