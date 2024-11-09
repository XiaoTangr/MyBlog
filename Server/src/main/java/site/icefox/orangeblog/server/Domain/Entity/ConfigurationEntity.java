package site.icefox.orangeblog.server.Domain.Entity;

import lombok.Data;

@Data
public class ConfigurationEntity {
    private String id;
    private String key;
    private String value;
}
