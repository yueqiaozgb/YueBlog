import request from '@/axios/index.ts'

export function getBlogById(token: string, id: number) {
    return request({
        url: 'blog',
        method: 'GET',
        headers: {
            Authorization: token,
        },
        params: {
            id: id
        }
    })
}

export function getSearchBlogList(query: string) {
    return request({
        url: 'searchBlog',
        method: 'GET',
        params: {
            query
        }
    })
}