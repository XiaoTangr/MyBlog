package site.icefox.orangeblog.server.Common.Util;

import lombok.Data;
import lombok.Getter;
import org.springframework.web.client.HttpClientErrorException;

public class ResultUtil {

    // 响应码枚举
    @Getter
    public enum ResultCode {

        SUCCESS(200, "操作成功"),
        ERROR(500, "操作失败"),
        UNAUTHORIZED(401, "未授权");

        // 可以根据需要添加更多状态码

        private Integer code;
        private String message;

        ResultCode(Integer code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    // 响应数据结构
    @Data
    public static class Result<T> {
        private Integer code; // 响应码
        private String message; // 响应信息
        private T data; // 响应数据

        public Result(ResultCode resultCode) {
            this.code = resultCode.getCode();
            this.message = resultCode.getMessage();
        }

        public Result(ResultCode resultCode, T data) {
            this.code = resultCode.getCode();
            this.message = resultCode.getMessage();
            this.data = data;
        }

        public Result(int code, T data, String message) {
            this.code = code;
            this.message = message;
            this.data = data;
        }
    }

    // 成功返回方法，不指定具体类型
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }


    public static <T> Result<T> success(String msg) {
        Result<T> result = new Result<>(ResultCode.SUCCESS);
        result.setMessage(msg);
        return result;
    }


    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<>(ResultCode.SUCCESS);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    // 错误返回方法，不指定具体类型
    public static <T> Result<T> error(T data) {
        return new Result<>(ResultCode.ERROR, data);
    }

    // 错误返回方法，带消息，不指定具体类型
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>(ResultCode.ERROR);
        result.setMessage(message);
        return result;
    }

    // 错误返回方法，不带数据
    public static <T> Result<T> error() {
        return new Result<>(ResultCode.ERROR, null);
    }
}
