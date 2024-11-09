package site.icefox.orangeblog.server.Interceptor;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import site.icefox.orangeblog.server.Common.Util.ResultUtil;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 调用Unauthorized方法获取未授权的结果
//        ResultUtil.Result<Void> result = ResultUtil.Unauthorized();
//
//        // 设置响应状态码
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//        // 将结果转换为JSON字符串并写入响应
//        String jsonResponse = JSON.toJSONString(result);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.getWriter().write(jsonResponse);
//
//        // 返回false表示请求被拦截，不会继续执行后续的处理器
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
