import request from "@/utils/request";

export const listTag = () => {
    return request({
        url: "/tag/list",
        method: "get",
    });
}

export const getTag = (id) => {
    return request({
        url: "/tag/" + id,
        method: "get",
    });
}