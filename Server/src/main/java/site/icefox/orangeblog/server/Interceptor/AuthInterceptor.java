package site.icefox.orangeblog.server.Interceptor;


import com.alibaba.fastjson.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import site.icefox.orangeblog.server.Common.Util.JWTUtil;
import site.icefox.orangeblog.server.Common.Util.ResultUtil;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final Logger logger = LogManager.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null || !JWTUtil.verifyToken(token)) {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            ResultUtil.Result<Object> data = new ResultUtil.Result<>(501, null, "Authentication");
            response.getWriter().write(JSON.toJSONString(data));
            return false;
        }
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
