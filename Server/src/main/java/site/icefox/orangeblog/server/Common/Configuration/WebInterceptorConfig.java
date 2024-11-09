package site.icefox.orangeblog.server.Common.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import site.icefox.orangeblog.server.Interceptor.AuthInterceptor;

@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/api/v1/users/register")
                .excludePathPatterns("/api/v1/users/login");
    }
}
