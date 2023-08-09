import { createRouter, createWebHistory } from 'vue-router'

const routes = [
    {
        path: '/login',
        component: () => import('@/views/Login'),
        meta: {title: '登录'}
    },
    {
        path:'/',
        component:()=>import('../layout/Index.vue'),
        redirect: '/home',
        children:[
            {
                path:'/home',
                name: 'home',
                component:()=>import('../views/home/Index.vue'),
                meta:{
                    title:'首页'
                }
            },
            {
                path: '/blog/:id',
                name: 'blog',
                component: () => import('@/views/blog/Index.vue'),
                meta: {title: '博客'}
            },
            {
                path:'/category:name',
                name: 'category',
                component:()=>import('@/views/category/Index.vue'),
                meta:{
                    title:'分类'
                }
            },
            {
                path:'/archive',
                name: 'archive',
                component:()=>import('@/views/archive/Index.vue'),
                meta:{
                    title:'归档'
                }
            },
            {
                path: '/about',
                name: 'about',
                component: () => import('../views/about/Index.vue'),
                meta:{
                    title:'关于'
                }
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes,
})

export default router
