import request from "@/utils/request";

//用户登录接口
export function login(data) {
    return request({
        url: '/api/login',
        method: 'post',
        data
    })
}
