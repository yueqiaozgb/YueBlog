import request from '@/axios/index.ts'

export function getBlogList(pageNum) {
    return request({
        url: 'blogs',
        method: 'GET',
        params: {
            pageNum
        }
    })
}