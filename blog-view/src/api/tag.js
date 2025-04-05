import request from "@/utils/request";

export const listTag = () => {
    return request({
        url: "/tag/list",
        method: "get",
    });
}