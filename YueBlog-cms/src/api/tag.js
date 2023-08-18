import axios from '@/util/request'

export function getData(queryInfo) {
	return axios({
		url: '/tag/listByQuery',
		method: 'GET',
		params: {
			...queryInfo
		}
	})
}

export function addTag(form) {
	return axios({
		url: '/tag',
		method: 'POST',
		data: {
			...form
		}
	})
}

export function editTag(form) {
	return axios({
		url: '/tag',
		method: 'PUT',
		data: {
			...form
		}
	})
}

export function deleteTagById(id) {
	return axios({
		url: '/tag/' + id,
		method: 'DELETE'
	})
}	

export function tagList() {
	return axios({
		url: '/tag/list',
		method: 'GET'
	})
}