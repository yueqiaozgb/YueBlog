const blog = () => import("@/views/blog/index.vue")

const editBlog = () => import("@/views/blog/edit/index.vue")

const category = () => import("@/views/category/index.vue")

const tag = () => import("@/views/tag/index.vue")

const route = [
    {
        path: "/blog",
        name: "blog",
        component: blog,
    },
    {
        path: "/blog/edit",
        name: "blogEdit",
        component: editBlog,
    },
    {
        path: "/category",
        name: "category",
        component: category,
    },
    {
        path: "/tag",
        name: "tag",
        component: tag,
    }
]

export default route
