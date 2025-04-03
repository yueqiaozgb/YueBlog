import request from "@/utils/request";

export const listCategory = () => {
    return request({
        url: "/category/list",
        method: "get",
    });
}