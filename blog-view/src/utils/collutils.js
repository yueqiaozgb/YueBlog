/**
 * 在对象数组中查找第一个包含指定属性值的对象
 * @param {Array} arr - 要查询的对象数组
 * @param {string} prop - 要检查的对象属性名
 * @param {*} targetValue - 要匹配的目标值
 * @returns {Object|undefined} - 返回匹配的对象，未找到时返回 undefined
 */
export function findObjectByValue(arr, prop, targetValue) {
    return arr.find(obj => obj[prop] === targetValue);
}