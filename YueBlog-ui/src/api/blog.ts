import request from '@/axios/index.ts'

export function getBlogById(token: string, id: number) {
    return request({
        url: 'blog',
        method: 'GET',
        headers: {
            Authorization: token,
        },
        params: {
            id
        }
    })
}

export function checkBlogPassword(blogPasswordForm: any) {
    return request({
        url: 'checkBlogPassword',
        method: 'POST',
        data: {
            ...blogPasswordForm
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