import request from "@/utils/request";

export const randomBlog = () => {
    return request({
        url: "/blog/random",
        method: "get",
    });
}

export const listBlog = (data) => {
    return request({
        url: "/blog/list",
        method: "get",
        params: data
    });
}