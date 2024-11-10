import axios from 'axios';
import { ElMessage } from 'element-plus';
const request = axios.create({
    baseURL: "/api/v1",
})

// 请求拦截器
request.interceptors.request.use(
    // 在发送请求之前调用
    (config) => {
        const newConfig = config;
        // 添加 token
        Object.assign(newConfig.headers,
            { 'Authorization': localStorage.getItem("Authorization"), }
        );
        return newConfig;
    },
    (error): Promise<never> => {
        // 对请求错误时调用，可自己定义
        return Promise.reject(error);
    }
);

// 响应拦截器
request.interceptors.response.use(
    (response) => {
        // 2xx 范围内的状态码都会触发该函数。对响数据成功时调用。
        if (response.data.code !== 200) {
            ElMessage.error(response.data.message);
        }
        if (response.headers.authorization) {
            localStorage.setItem('Authorization', response.headers.authorization);
        }
        return response;
    },
    (error): Promise<never> => {
        // 超出 2xx 范围的状态码都会触发该函数。对响应错误时调用。
        ElMessage.error(error);
        return Promise.reject(error);
    }
);

export default request;