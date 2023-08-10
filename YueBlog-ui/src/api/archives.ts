import request from '@/axios/index.ts'

export function getArchives() {
    return request({
        url: 'archives',
        method: 'GET'
    })
}