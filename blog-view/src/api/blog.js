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

export const getBlog = (id) => {
    return request({
        url: "/blog/" + id,
        method: "get",
    });
}