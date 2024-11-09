package site.icefox.orangeblog.server.Domain.Mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import site.icefox.orangeblog.server.Domain.Entity.UsersEntity;

@Mapper
public interface UsersMapper {

    @Select("select * from t_users where email = #{email}")
    UsersEntity queryUserbyEmail(@Param("email") String email);
}
