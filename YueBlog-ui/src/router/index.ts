import { createRouter, createWebHistory } from 'vue-router'

const routers = [
    {
        path:'/',
        component:()=>import('../views/index.vue'),
        redirect: '/home',
        children:[
            {
                path:'/home',
                component:()=>import('../views/home/index.vue'),
                meta:{
                    title:'首页'
                }
            }
        ]
    }
]

const router = createRouter({
    // hash模式
    // history: createWebHashHistory(),
    history: createWebHistory(),
    base: process.env.BASE_URL,
    routes: routes,
})

router.beforeEach((to, from, next) => {
    document.title = getPageTitle(to.meta.title)
    next()
})

export default router
