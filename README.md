# 简介

现在是2023年8月20日，非常感慨，完成了自己的博客系统初版，在这里非常感谢[Naccl](https://github.com/naccl)大佬，项目前端主要~~copy~~借鉴了大佬的项目

具体可以前往[NBlog](https://github.com/Naccl/NBlog)查看



# 后端

1. 核心框架：[Spring Boot](https://github.com/spring-projects/spring-boot)
2. 安全框架：[sa-token
3. ORM 框架：[MyBatis](https://github.com/baomidou/mybatis-plus)
4. NoSQL 缓存：[Redis](https://github.com/redis/redis)
5. Markdown 转 HTML：[commonmark-java](https://github.com/commonmark/commonmark-java)



注意事项，项目使用Java17开发，部署的时候请考虑环境

~~话说应该没人会拉取我的项目吧~~

mysql推荐8.0以上的版本，5和8的默认字符集不一致，可能会出现字符异常问题

用户名是Admin，密码是123456，可以在SecurityUtils打印密码然后存储在数据库中



# 前端

**前台ui：**

核心框架：[Vue3](https://github.com/vitejs/vite) + [element-plus](https://github.com/element-plus/element-plus)

前台项目使用vite搭建，语言为ts，node版本为18.17.0，二次开发请注意配置插件



**后台cms:**

核心框架：[Vue2](https://github.com/vuejs/vue) + [element-ui](https://github.com/ElemeFE/element)

后台项目使用vue cli搭建，语言为js，node版本为14.21.3，二次开发请注意配置插件



项目使用了代理服务器，没有在后端设置跨域，如果想使用nginx代理，请配置/api的路径，或者配置后端的cors，本地直接运行即可

项目的npm依赖推荐为16.x，由于npm18以后的加密算法问题，无法直接运行后台，推荐安装[nvm](https://github.com/nvm-sh/nvm)



# 碎碎念

一年前就想写一个自己的博客了，但是当时能力不足，代码都看得不太懂，更别手动了，只是把别人的代码拉下来跑一下，现在可以写出自己的博客了，算是对自己的一个交代吧，后续会在博客中更新，有什么问题可以在issue中提问，也可以直接[发邮件](mailto:yueqiaozgb@163.com)

博客预览地址：[Yue's Blog](http://43.138.86.8:8095/home)

对了，博客只有基本的阅读和查找功能，至于评论什么的，原因是现在的网站监管问题，不能出现登录，评论等功能，如果要添加的话，需要管理员审核，我没有时间，选择最简单的方式，砍需求，完美解决问题

