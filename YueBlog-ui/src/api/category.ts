import request from '@/axios/index.ts'

export function getBlogListByCategoryName(categoryName: string, pageNum: number) {
    return request({
        url: 'category',
        method: 'GET',
        params: {
            categoryName: categoryName,
            pageNum: pageNum
        }
    })
}