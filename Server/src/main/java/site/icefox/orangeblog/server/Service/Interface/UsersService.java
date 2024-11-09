package site.icefox.orangeblog.server.Service.Interface;


import site.icefox.orangeblog.server.Domain.Entity.UsersEntity;

public interface UsersService {
    UsersEntity queryUsersByEmail(String email);
}
