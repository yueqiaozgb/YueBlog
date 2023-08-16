import request from '@/axios/index.ts'

export function getBlogListByCategoryName(categoryName: any, pageNum: number) {
    return request({
        url: '/blog/listByCategoryName',
        method: 'GET',
        params: {
            categoryName: categoryName,
            pageNum: pageNum
        }
    })
}