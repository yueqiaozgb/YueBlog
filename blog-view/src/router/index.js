import {createMemoryHistory, createRouter} from 'vue-router'

import Layout from '@/layout/index.vue'

const routes = [
    {
        path: '/',
        component: Layout
    },
]

const router = createRouter({
    history: createMemoryHistory(),
    routes,
})

export default router
