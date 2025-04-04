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
            }
        ]
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
