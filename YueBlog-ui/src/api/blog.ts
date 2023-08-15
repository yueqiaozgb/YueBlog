import request from '@/axios/index.ts'

export function getBlogById(id: number) {
    return request({
        url: 'blog',
        method: 'GET',
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