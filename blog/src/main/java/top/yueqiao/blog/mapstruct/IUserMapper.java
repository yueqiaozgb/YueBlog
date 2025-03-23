package top.yueqiao.blog.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import top.yueqiao.blog.domain.entity.User;
import top.yueqiao.blog.model.bo.UserBo;

/**
 * @author yueqiao
 * @date 2025/03/12/15:18
 */
@Mapper
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    @Mappings({
            @Mapping(target = "permissionList", ignore = true),
            @Mapping(target = "roleList", ignore = true)
    })
    UserBo userToUserBo(User user);

}
