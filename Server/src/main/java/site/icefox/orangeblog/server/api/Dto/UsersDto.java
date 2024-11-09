package site.icefox.orangeblog.server.api.Dto;

import lombok.Data;

@Data
public class UsersDto {
    private int id;
    private String username;
    private String email;
    private int role;
}
