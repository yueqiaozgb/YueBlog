import request from '@/axios/index.ts'

export function getHitokoto() {
    return request({
        url: 'https://v1.hitokoto.cn/?c=a',
        method: 'GET'
    })
}

export function getSite() {
    return request({
        url: '/site',
        method: 'GET'
    })
}