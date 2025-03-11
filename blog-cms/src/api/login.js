import request from "@/utils/request";

export const login = params => {
    return request({
        url: "/user/doLogin",
        method: "post",
        data: params,
    });
};
