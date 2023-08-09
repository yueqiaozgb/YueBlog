import { createRouter, createWebHistory } from 'vue-router'

const routes = [
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
                path:'/category',
                component:()=>import('@/views/category/Index.vue'),
                meta:{
                    title:'分类'
                }
            },
            {
                path:'/tag',
                component:()=>import('@/views/tag/Index.vue'),
                meta:{
                    title:'标签'
                }
            },
            {
                path:'/archive',
                component:()=>import('@/views/archive/Index.vue'),
                meta:{
                    title:'归档'
                }
            },
            {
                path: '/about',
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
