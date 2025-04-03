import axios from "axios";

const request = axios.create({
    baseURL: "/api/view",
    timeout: 60 * 1000, // 请求超时秒数
});

request.interceptors.response.use(
    function (response) {
        // 2xx 范围内的状态码都会触发该函数。
        return response.data;
    },
    function (error) {
        // 超出 2xx 范围的状态码都会触发该函数。
        // 对响应错误做点什么
        return Promise.reject(error);
    }
);

export default request;