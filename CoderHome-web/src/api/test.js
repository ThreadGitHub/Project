import request from "@/utils/request";

//测试 axios
export function baidu() {
    return request({
        url: 'https://www.baidu.com',
        method: 'get'
    })
}
