const route = [
    {
        path: "/blog",
        name: "blog",
        component: () => import("@/views/blog/index.vue")
    },
    {
        path: "/blog/edit",
        name: "blogEdit",
        component: () => import("@/views/blog/edit/index.vue")
    },
    {
        path: "/category",
        name: "category",
        component: () => import("@/views/category/index.vue")
    },
    {
        path: "/tag",
        name: "tag",
        component: () => import("@/views/tag/index.vue")
    },
    {
        path: "/website",
        name: "website",
        component: () => import("@/views/website/index.vue")
    }
]

export default route
