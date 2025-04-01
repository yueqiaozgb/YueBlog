import request from "@/utils/request";

export const listCategory = () => {
    return request({
        url: "/category/list",
        method: "get",
    });
};

export const getCategory = id => {
    return request({
        url: "/category/" + id,
        method: "get",
    });
};

export const addCategory = data => {
    return request({
        url: "/category",
        method: "post",
        data,
    });
};

export const updateCategory = (data) => {
    return request({
        url: "/category",
        method: "put",
        data,
    });
}

export const delCategory = id => {
    return request({
        url: "/category/" + id,
        method: "delete",
    });
};
