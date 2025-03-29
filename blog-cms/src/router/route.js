const blog = () => import("@/views/blog/index.vue")

const blogInfo = () => import("@/views/blog/info.vue")

const route = [
    {
        path: "/blog",
        name: "blog",
        component: blog,
    },
    {
        path: "/blog/info",
        name: "blogInfo",
        component: blogInfo,
    }
]

export default route
