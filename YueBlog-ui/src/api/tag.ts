import request from '@/axios/index.ts'
import {RouteParamValue} from "vue-router";

export function getBlogListByTagName(tagName: string | RouteParamValue[], pageNum: number) {
    return request({
        url: '/blog/listByTagName',
        method: 'GET',
        params: {
            tagName: tagName,
            pageNum: pageNum
        }
    })
}