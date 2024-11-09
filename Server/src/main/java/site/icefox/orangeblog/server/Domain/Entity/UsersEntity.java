package site.icefox.orangeblog.server.Domain.Entity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;


@Data
public class UsersEntity {
    private int id;
    private String username;
    private String email;
    //    @JSONField(serialize = false)
    private String password;
    private int role;
}
