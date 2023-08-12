import request from '@/axios/index.ts'

export function getBlogListByTagName(tagName: string, pageNum: number) {
    return request({
        url: 'tag',
        method: 'GET',
        params: {
            tagName: tagName,
            pageNum: pageNum
        }
    })
}