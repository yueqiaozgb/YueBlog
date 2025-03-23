import request from "@/utils/request";

export const blog = () => {
    return request({
        url: "/blog",
        method: "get"
    });
};