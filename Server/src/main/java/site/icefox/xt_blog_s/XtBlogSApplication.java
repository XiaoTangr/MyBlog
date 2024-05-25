package site.icefox.xt_blog_s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("site.icefox.xt_blog_s.mapper")

public class XtBlogSApplication {

    public static void main(String[] args) {
        SpringApplication.run(XtBlogSApplication.class, args);
    }

}
