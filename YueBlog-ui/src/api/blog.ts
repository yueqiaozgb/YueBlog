import request from '@/axios/index.ts'

export function getBlogById(id: number) {
    return request({
        url: '/blog/' + id,
        method: 'GET'
    })
}

export function getSearchBlogList(query: string) {
    return request({
        url: '/blog/listByQuery',
        method: 'GET',
        params: {
            query: query
        }
    })
}