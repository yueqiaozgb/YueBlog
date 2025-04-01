import request from "@/utils/request";

export const listTag = () => {
    return request({
        url: "/tag/list",
        method: "get",
    });
}

export const getTag = id => {
    return request({
        url: "/tag/" + id,
        method: "get",
    });
}

export const addTag = data => {
    return request({
        url: "/tag",
        method: "post",
        data,
    });
}

export const updateTag = (data) => {
    return request({
        url: "/tag",
        method: "put",
        data,
    });
}

export const delTag = id => {
    return request({
        url: "/tag/" + id,
        method: "delete",
    });
}