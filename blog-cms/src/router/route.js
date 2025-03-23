const blog = () => import("@/views/blog/index.vue")

const route = [
    // 配置示例：菜单页
    {
        path: "/blog",
        name: "blog",
        component: blog,
    },
]

export default route