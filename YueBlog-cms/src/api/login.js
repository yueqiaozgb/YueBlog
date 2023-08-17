import axios from '@/util/request'

export function login(loginForm) {
	return axios({
		url: '/user/login',
		method: 'POST',
		data: {
			...loginForm
		}
	})
}
