import request from "@/utils/request";

export const login = params => {
    return request({
        url: "/user/login",
        method: "post",
        params: params,
    });
};
