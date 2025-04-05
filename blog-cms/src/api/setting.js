import request from "@/utils/request";

export const listSetting = () => {
    return request({
        url: "/site-setting/list",
        method: "get",
    });
}

export const getSetting = id => {
    return request({
        url: "/site-setting/" + id,
        method: "get",
    });
}

export const addSetting = data => {
    return request({
        url: "/site-setting",
        method: "post",
        data,
    });
}

export const updateSetting = (data) => {
    return request({
        url: "/site-setting",
        method: "put",
        data,
    });
}

export const delSetting = id => {
    return request({
        url: "/site-setting/" + id,
        method: "delete",
    });
}

export const getSettingType = () => {
    return request({
        url: "/site-setting/type",
        method: "get",
    });
}