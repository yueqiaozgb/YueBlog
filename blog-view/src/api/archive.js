import request from "@/utils/request";

export const listArchive = () => {
    return request({
        url: "/archive/list",
        method: "get",
    });
}
