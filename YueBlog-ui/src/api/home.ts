import request from '@/axios/index.ts'

export function getBlogList(pageNum: number) {
    return request({
        url: 'blogs',
        method: 'GET',
        params: {
            pageNum: pageNum
        }
    })
}