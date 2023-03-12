import request from "@/utils/request";

/**
 * 用户登录接口
 * @param data
 * @returns {AxiosPromise}
 */
export function login(data) {
    return request({
        url: '/api/user/login',
        method: 'post',
        data
    })
}

/**
 * 用户注册接口
 * @param data
 * @returns {AxiosPromise}
 */
export function register(data) {
    return request({
        url: '/api/user/register',
        method: 'post',
        data
    })
}
