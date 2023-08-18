import axios from '@/util/request'

export function getSiteSettingData() {
	return axios({
		url: '/site',
		method: 'GET'
	})
}

export function update(settings, deleteIds) {
	return axios({
		url: '/site',
		method: 'POST',
		data: {
			settings,
			deleteIds
		}
	})
}

export function getWebTitleSuffix() {
	return axios({
		url: 'webTitleSuffix',
		method: 'GET'
	})
}