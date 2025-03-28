package top.yueqiao.blog.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.yueqiao.blog.domain.entity.Blog;
import top.yueqiao.blog.domain.entity.Tag;
import top.yueqiao.blog.domain.model.vo.BlogEditVo;
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

    @Mapping(target = ".", source = "blog")
    @Mapping(target = "tagList", source = "tagList")
    BlogEditVo blogToBlogEditVo(Blog blog, List<Tag> tagList);

}
