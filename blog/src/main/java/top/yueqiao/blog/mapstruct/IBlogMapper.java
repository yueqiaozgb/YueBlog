package top.yueqiao.blog.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.model.dto.BlogEditDto;
import top.yueqiao.blog.domain.model.vo.BlogDetailVo;
import top.yueqiao.blog.domain.model.vo.BlogEditVo;
import top.yueqiao.blog.domain.model.vo.BlogInfoVo;
import top.yueqiao.blog.domain.model.vo.BlogListItemVo;

import java.util.List;

/**
 * @author yueqiao
 * @date 2025/03/28/17:15
 */
@Mapper
public interface IBlogMapper {

    IBlogMapper INSTANCE = Mappers.getMapper(IBlogMapper.class);

    BlogListItemVo blogToBlogListItemVo(Blog blog);

    @Mapping(target = "tagIdList", source = "tagIdList")
    BlogEditVo blogToBlogEditVo(Blog blog, List<Integer> tagIdList);

    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Blog blogEditDtoToBlog(BlogEditDto blogEditDto);

    @Mapping(target = "tagList", ignore = true)
    @Mapping(target = "category", ignore = true)
    BlogInfoVo blogToBlogInfoVo(Blog blog);

    @Mapping(target = "tagList", ignore = true)
    @Mapping(target = "category", ignore = true)
    BlogDetailVo blogToBlogDetailVo(Blog blog);

}
