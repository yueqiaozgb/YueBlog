import request from "@/utils/request";

export const listBlog = (data) => {
    return request({
        url: "/blog/list",
        method: "get",
        params: data
    });
};

export const getBlog = id => {
    return request({
        url: "/blog/" + id,
        method: "get"
    });
}

export const delBlog = id => {
    return request({
        url: "/blog/" + id,
        method: "delete"
    });
}
