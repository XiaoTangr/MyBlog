package site.icefox.XtBlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("site.icefox.XtBlog.mapper")

public class XtBlogSApplication {

    public static void main(String[] args) {
        SpringApplication.run(XtBlogSApplication.class, args);
    }

}
