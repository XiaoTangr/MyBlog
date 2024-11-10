package site.icefox.orangeblog.server.api.Dto;

import lombok.Data;

@Data
public class ConfigurationDto {
    private String id;
    private String key;
    private String value;
}
