package site.icefox.orangeblog.server.Domain.Mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import site.icefox.orangeblog.server.Domain.Entity.UsersEntity;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from t_users where email = #{email}")
    UsersEntity queryUserbyEmail(@Param("email") String email);

    @Select("select * from t_users")
    List<UsersEntity> queryAllUsers();

    @Select("delete from t_users where email = #{email}")
    void deleteUser(@Param("email") String email);

    @Insert("INSERT INTO t_users (email, username, password, role) VALUES (#{email}, #{username}, #{password}, #{role})")
    void saveUser(UsersEntity user);
}
