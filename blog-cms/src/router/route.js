const blog = () => import("@/views/blog/index.vue")

const route = [
    {
        path: "/blog",
        name: "blog",
        component: blog,
    }
]

export default route
