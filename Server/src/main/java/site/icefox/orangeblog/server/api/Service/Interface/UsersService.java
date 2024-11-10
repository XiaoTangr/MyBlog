package site.icefox.orangeblog.server.api.Service.Interface;


import site.icefox.orangeblog.server.Domain.Entity.UsersEntity;
import site.icefox.orangeblog.server.api.Dto.UsersDto;

import java.util.List;

public interface UsersService {
    UsersDto queryUsersByEmail(String email);

    UsersDto login(String email, String password);

    List<UsersDto> queryAllUsers();

    UsersDto saveUser(UsersEntity user);
}
