package site.icefox.orangeblog.server.Common.Advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import site.icefox.orangeblog.server.Common.Util.ResultUtil;

@ControllerAdvice
public class ResBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 如果返回类型已经是 Result 类型，则不进行包装
        return !ResultUtil.Result.class.isAssignableFrom(returnType.getParameterType());
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果返回值不是 Result 类型，则包装为成功并包含数据
        // 这里我们不再检查 body 是否为 null，因为如果为 null，则应该由具体的方法来决定返回值
        if (body instanceof ResultUtil.Result) {
            return body; // 如果已经是 Result 类型，则直接返回
        } else {
            return ResultUtil.success(body); // 包装为 Result 类型
        }
//        return body;
    }
}
