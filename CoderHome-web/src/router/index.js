import {createRouter, createWebHistory} from 'vue-router'

const routes = [
    {
        path: '/index',
        name: 'Index',
        component: () => import('../views/Index')
    },
    {
        path: '/',
        component: () => import('../views/Index')
    },
    {
        path: '/test',
        name: 'Test',
        component: () => import('../views/Test')
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import('../views/Login')
    }
]

const router = createRouter({
    //设置地址路由方式为 history
    history: createWebHistory(),
    routes
})

export default router
