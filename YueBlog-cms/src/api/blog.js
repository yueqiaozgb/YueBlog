import axios from '@/util/request'

export function getDataByQuery(queryInfo) {
	return axios({
		url: '/blog/list',
		method: 'GET',
		params: {
			...queryInfo
		}
	})
}

export function deleteBlogById(id) {
	return axios({
		url: '/blog/' + id,
		method: 'DELETE'
	})
}

export function saveBlog(blog) {
	return axios({
		url: '/blog',
		method: 'POST',
		data: {
			...blog
		}
	})
}

export function getBlogById(id) {
	return axios({
		url: '/blog/' + id,
		method: 'GET'
	})
}

export function updateBlog(blog) {
	return axios({
		url: 'blog',
		method: 'PUT',
		data: {
			...blog
		}
	})
}