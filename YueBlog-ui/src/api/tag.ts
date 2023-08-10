import request from '@/axios/index.ts'

export function getBlogListByTagName(tagName, pageNum) {
    return request({
        url: 'tag',
        method: 'GET',
        params: {
            tagName: tagName,
            pageNum: pageNum
        }
    })
}