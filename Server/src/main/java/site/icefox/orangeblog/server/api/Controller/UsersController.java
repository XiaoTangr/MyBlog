package site.icefox.orangeblog.server.api.Controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.icefox.orangeblog.server.Common.Util.ResultUtil;
import site.icefox.orangeblog.server.Domain.Entity.UsersEntity;
import site.icefox.orangeblog.server.Service.Impl.UsersServiceImpl;
import site.icefox.orangeblog.server.api.Dto.UsersDto;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    UsersServiceImpl us;


    @GetMapping("/getusers")
    public UsersDto getUsers(@Param("email") String email) {
        UsersEntity user = us.queryUsersByEmail(email);
        if (user == null) {
            throw new RuntimeException("获取用户信息失败");
        }

        UsersDto result = new UsersDto();
        BeanUtils.copyProperties(user, result);

        return result;
    }


    @GetMapping("/test")
    public void test() {
        ResultUtil.success("Users", null);
    }
}
