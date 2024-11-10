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

    /**
     * 响应数据结构
     *
     * @param <T>
     */
    @Data
    public static class Result<T> {
        private Integer code; // 响应码
        private String message; // 响应信息
        private T data; // 响应数据

        /**
         * 构造方法
         *
         * @param resultCode resultCode
         */
        public Result(ResultCode resultCode) {
            this.code = resultCode.getCode();
            this.message = resultCode.getMessage();
        }

        /**
         * 构造方法
         *
         * @param resultCode resultCode
         * @param data       响应数据
         */
        public Result(ResultCode resultCode, T data) {
            this.code = resultCode.getCode();
            this.message = resultCode.getMessage();
            this.data = data;
        }

        /**
         * 构造方法
         *
         * @param code    响应码
         * @param message 响应信息
         * @param data    data
         */
        public Result(int code, T data, String message) {
            this.code = code;
            this.message = message;
            this.data = data;
        }
    }

    /**
     * 成功返回方法，不指定具体类型
     *
     * @param data data
     * @param <T>  T
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    /**
     * 成功返回方法，不指定具体类型
     *
     * @param msg msg
     * @param <T> T
     * @return result
     */
    public static <T> Result<T> success(String msg) {
        Result<T> result = new Result<>(ResultCode.SUCCESS);
        result.setMessage(msg);
        return result;
    }


    /**
     * 成功返回方法，不指定具体类型
     *
     * @param msg  msg
     * @param data data
     * @param <T>  T
     * @return result
     */
    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<>(ResultCode.SUCCESS);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    //

    /**
     * 错误返回方法，不指定具体类型
     *
     * @param data data
     * @param <T>  T
     * @return result
     */
    public static <T> Result<T> error(T data) {
        return new Result<>(ResultCode.ERROR, data);
    }

    // 错误返回方法，带消息，不指定具体类型

    /**
     * @param message message
     * @param <T>     T
     * @return result
     */
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>(ResultCode.ERROR);
        result.setMessage(message);
        return result;
    }

    /**
     * 错误返回方法，不带数据
     *
     * @param <T> T
     * @return result
     */
    public static <T> Result<T> error() {
        return new Result<>(ResultCode.ERROR, null);
    }
}
