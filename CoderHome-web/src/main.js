import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

// Vue.prototype.$axios = axios //
// require("./mock") //引入mock数据，关闭则注释该行
createApp(App).use(ElementPlus).use(store).use(router).mount('#app')
