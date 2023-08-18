<template>
	<div>
		<el-form :model="form" :rules="formRules" ref="formRef" label-position="top">
			<el-row :gutter="20">
				<el-col :span="12">
					<el-form-item label="文章标题" prop="blogTitle">
						<el-input v-model="form.blogTitle" placeholder="请输入标题"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="文章首图URL" prop="blogCover">
						<el-input v-model="form.blogCover" placeholder="文章首图，用于随机文章展示"></el-input>
					</el-form-item>
				</el-col>
			</el-row>

			<el-form-item label="文章描述" prop="blogIntroduction">
				<mavon-editor v-model="form.blogIntroduction"/>
			</el-form-item>

			<el-form-item label="文章正文" prop="blogContent">
				<mavon-editor v-model="form.blogContent"/>
			</el-form-item>

			<el-row :gutter="20">
				<el-col :span="12">
					<el-form-item label="分类" prop="category">
						<el-select v-model="form.category" placeholder="请选择分类（输入可添加新分类）" :allow-create="false" :filterable="true" style="width: 100%;">
							<el-option :label="item.categoryName" :value="item.categoryId" v-for="item in categoryList" :key="item.categoryId"></el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="标签" prop="tagList">
						<el-select v-model="form.tagList" placeholder="请选择标签（输入可添加新标签）" :allow-create="false" :filterable="true" :multiple="true" style="width: 100%;">
							<el-option :label="item.tagName" :value="item.tagId" v-for="item in tagList" :key="item.tagId"></el-option>
						</el-select>
					</el-form-item>
				</el-col>
			</el-row>

			<el-row :gutter="20">
				<el-col :span="8">
					<el-form-item label="字数" prop="blogWords">
						<el-input v-model="form.blogWords" placeholder="请输入文章字数（自动计算阅读时长）" type="number"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="阅读时长(分钟)" prop="readTime">
						<el-input v-model="form.readTime" placeholder="请输入阅读时长（可选）默认 Math.round(字数 / 200)" type="number"></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="推荐指数" prop="recommendIndex">
						<el-input v-model="form.recommendIndex" placeholder="请输入文章字数（可选）默认为 0" type="number"></el-input>
					</el-form-item>
				</el-col>
			</el-row>

			<el-form-item style="text-align: right;">
				<el-button type="primary" @click="submit">保存</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	import Breadcrumb from "@/components/Breadcrumb";
	import {saveBlog, getBlogById, updateBlog} from '@/api/blog'
	import {tagList} from '@/api/tag'
	import {categoryList} from '@/api/category'

	export default {
		name: "WriteBlog",
		components: {Breadcrumb},
		data() {
			return {
				categoryList: [],
				tagList: [],
				form: {
					blogTitle: '',
					blogCover: '',
					blogIntroduction: '',
					blogContent: '',
					catecory: null,	
					tagList: [],
					blogWords: null,
					readTime: null,
					recommendIndex: 0
				},
				formRules: {
					blogTitle: [{required: true, message: '请输入标题', trigger: 'change'}],
					blogCover: [{required: true, message: '请输入首图链接', trigger: 'change'}],
					catecory: [{required: true, message: '请选择分类', trigger: 'change'}],
					tagList: [{required: true, message: '请选择标签', trigger: 'change'}],
					blogWords: [{required: true, message: '请输入文章字数', trigger: 'change'}],
				},
			}
		},
		watch: {
			'form.blogWords'(newValue) {
				this.form.readTime = newValue ? Math.round(newValue / 200) : null
			},
		},
		created() {
			this.getData()
			if (this.$route.params.id) {
				this.getBlog(this.$route.params.id)
			}
		},
		methods: {
			getData() {
				tagList().then(res => {
					this.tagList = res.data
				})
				categoryList().then(res => {
					this.categoryList = res.data
				})
			},
			getBlog(id) {
				getBlogById(id).then(res => {
					this.computeCategoryAndTag(res.data)
					this.form = res.data
				})
			},
			computeCategoryAndTag(blog) {
				blog.category = blog.category.categoryId
				blog.tagList = []
				blog.tags.forEach(item => {
					blog.tagList.push(item.tagId)
				})
			},
			submit() {
				this.$refs.formRef.validate(valid => {
					if (valid) {
						if (this.$route.params.id) {
							updateBlog(this.form).then(res => {
								this.msgSuccess(res.msg)
								this.$router.push('/blog/list')
							})
						} else {
							saveBlog(this.form).then(res => {
								this.msgSuccess(res.msg)
								this.$router.push('/blog/list')
							})
						}
					} else {
						return this.msgError('请填写必要的表单项')
					}
				})
			}
		}
	}
</script>

<style scoped>

</style>