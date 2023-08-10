import request from '@/axios/index.ts'

export function getBlogListByCategoryName(categoryName, pageNum) {
    return request({
        url: 'category',
        method: 'GET',
        params: {
            categoryName: categoryName,
            pageNum: pageNum
        }
    })
}