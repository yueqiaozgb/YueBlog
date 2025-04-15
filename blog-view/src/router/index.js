import {createWebHistory, createRouter} from 'vue-router'

import Layout from '@/layout/index.vue'

const routes = [
    {
        path: '/',
        component: Layout,
        redirect: '/home',
        children: [
            {
                path: 'home',
                component: () => import('@/views/home/index.vue'),
            },
            {
                path: '/blog/:id',
                name: 'blog',
                component: () => import('@/views/blog/index.vue'),
                meta: {title: '博客'}
            },
            {
                path: '/tag/:id',
                name: 'tag',
                component: () => import('@/views/tag/index.vue'),
                meta: {title: '标签'}
            },
            {
                path: '/category/:id',
                name: 'category',
                component: () => import('@/views/category/index.vue'),
                meta: {title: '分类'}
            },
            {
                path: '/archive',
                name: 'archive',
                component: () => import('@/views/archive/index.vue'),
                meta: {title: '归档'}
            }
        ]
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
