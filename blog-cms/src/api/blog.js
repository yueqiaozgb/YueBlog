import request from "@/utils/request";

export const listBlog = () => {
    return request({
        url: "/blog/list",
        method: "get"
    });
};

export const getBlog = id => {
    return request({
        url: "/blog/" + id,
        method: "get"
    });
}
