import request from '@/axios/index.ts'

export function getAbout() {
    return request({
        url: '/about',
        method: 'GET'
    })
}