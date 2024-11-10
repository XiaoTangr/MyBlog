package site.icefox.orangeblog.server.api.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.icefox.orangeblog.server.Common.Util.JWTUtil;
import site.icefox.orangeblog.server.Domain.Entity.UsersEntity;
import site.icefox.orangeblog.server.api.Service.Impl.UsersServiceImpl;
import site.icefox.orangeblog.server.api.Dto.UsersDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    UsersServiceImpl us;

    @GetMapping("/getuser")
    public List<UsersDto> getUsers() {
        return us.queryAllUsers();
    }

    @GetMapping("/getuser/{email}")
    public UsersDto getUser(@PathVariable("email") String email) {
        return us.queryUsersByEmail(email);
    }

    @PostMapping("/register")
    public UsersDto register(@RequestBody UsersEntity usersEntity) {
        return us.saveUser(usersEntity);
    }

    @PostMapping("/login")
    public UsersDto login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpServletResponse response) {
        UsersDto user = us.login(email, password);
        if (user != null) {
            JWTUtil.TokenBody tb = new JWTUtil.TokenBody();
            tb.setUser_name(user.getUsername());
            tb.setUser_email(user.getEmail());
            tb.setUser_role(user.getRole());
            String token = JWTUtil.generateToken(tb);
            // 设置响应头
            response.setHeader("Authorization", token);
            return user;
        }
        throw new RuntimeException("登录失败");
    }
}
