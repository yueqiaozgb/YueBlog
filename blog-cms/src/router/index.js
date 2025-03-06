import { createRouter,createWebHistory } from "vue-router";

const routes = [
    {
        path:"/", //路径描述
        name:"home",
        component: () => import("../views/home/index.vue")
    }
]

const router = createRouter({
    history:createWebHistory(),
    routes :routes
})
export default router
