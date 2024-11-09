package site.icefox.orangeblog.server.Common.Advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import site.icefox.orangeblog.server.Common.Util.ResultUtil;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理特定类型的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultUtil.Result<Object> handleException(Exception e) {
        // 根据不同的异常类型，返回不同的响应码和信息
        if (e instanceof NullPointerException) {
            return ResultUtil.error("空指针异常");
        } else if (e instanceof IllegalArgumentException) {
            return ResultUtil.error("非法参数异常");
        } else {
            // 其他未定义的异常
            return ResultUtil.error("系统异常:" + e.getMessage());
        }
    }

    // 可以定义更多的异常处理方法来处理不同的异常
}
