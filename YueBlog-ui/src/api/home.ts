import request from '@/axios/index.ts'

export function getBlogList(pageNum: number) {
    return request({
        url: '/blog/list',
        method: 'GET',
        params: {
            pageNum: pageNum
        }
    })
}