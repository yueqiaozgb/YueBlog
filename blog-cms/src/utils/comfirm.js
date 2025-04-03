import {ElMessageBox, ElMessage} from 'element-plus'

/**
 * 封装通用确认弹窗
 * @param {*[]} id 要操作的数据ID
 * @param {Function} apiFunc 需要调用的API函数
 * @returns {Promise}
 */
export const confirmDel = (
    id,
    apiFunc
) => {
    return ElMessageBox.confirm(
        '是否删除ID为' + id + '的数据?', '操作确认', {
            confirmButtonText: '确认',
            cancelButtonText: '关闭',
            type: 'warning'
        })
        .then(() => {
            return apiFunc(id).then(res => {
                if (res.code === 200) {
                    ElMessage.success('删除成功')
                } else {
                    ElMessage.error(res.msg)
                }
                return Promise.resolve(res)
            })
        })
        .catch(err => {
            if (err !== 'cancel') { // 非取消操作才显示错误
                ElMessage.error(err || '操作失败')
            }
            return Promise.reject(err)
        })
}

/**
 * 封装通用确认弹窗（添加操作）
 * @param {Object} data 添加的数据
 * @param {Function} apiFunc 需要调用的API函数
 * @returns {Promise}
 */
export const confirmAdd = (
    data,
    apiFunc
) => {
    return apiFunc(data)
        .then(res => {
            if (res.code === 200) {
                ElMessage.success('添加成功')
            } else {
                ElMessage.error(res.msg)
            }
            return Promise.resolve(res)
        })
        .catch(err => {
            if (err !== 'cancel') { // 非取消操作才显示错误
                ElMessage.error(err || '操作失败')
            }
            return Promise.reject(err)
        })
}

/**
 * 封装通用更新操作
 * @param {Object} data 添加的数据
 * @param {Function} apiFunc 需要调用的API函数
 * @returns {Promise}
 */
export const confirmUpdate = (
    data,
    apiFunc
) => {
    return apiFunc(data)
        .then(res => {
            if (res.code === 200) {
                ElMessage.success('更新成功')
            } else {
                ElMessage.error(res.msg)
            }
            return Promise.resolve(res)
        })
        .catch(err => {
            if (err !== 'cancel') { // 非取消操作才显示错误
                ElMessage.error(err || '操作失败')
            }
            return Promise.reject(err)
        })
}

