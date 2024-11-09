package site.icefox.orangeblog.server.Service.Impl;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import site.icefox.orangeblog.server.Domain.Entity.UsersEntity;
import site.icefox.orangeblog.server.Domain.Mapper.UsersMapper;
import site.icefox.orangeblog.server.Service.Interface.UsersService;

@Service
@Log4j2
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;


    public UsersEntity queryUsersByEmail(String email) {
        log.warn("query user, email: {}", email);
        return usersMapper.queryUserbyEmail(email);
    }
}
