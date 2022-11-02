import axios from "axios";

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
const service = axios.create({
    //超时时间10秒
    timeout: 10000
});

axios.interceptors.request.use(function (config){
    let token = '';
    let user = localStorage.getItem("user");
    if (user) {
        token = user;
    }
    config.headers['Authorization'] = `Bearer ${token}`;
    return config;
})

export default axios;