import request from "@/utils/request";

export const listSetting = () => {
    return request({
        url: "/site-setting/list",
        method: "get",
    });
}