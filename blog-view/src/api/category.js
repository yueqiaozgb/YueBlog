import request from "@/utils/request";

export const listCategory = () => {
    return request({
        url: "/category/list",
        method: "get",
    });
}

export const getCategory = id => {
    return request({
        url: "/category/" + id,
        method: "get",
    });
}