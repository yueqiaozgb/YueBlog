import request from "@/utils/request";

export const randomBlog = () => {
    return request({
        url: "/blog/random",
        method: "get",
    });
}