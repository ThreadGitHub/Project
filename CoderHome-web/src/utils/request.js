import axios from "axios";

axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
const service = axios.create({
    //超时时间10秒
    timeout: 10000
});

export default axios;
