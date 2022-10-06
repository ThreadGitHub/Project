const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 设置vue服务器代理后台服务地址
  devServer: {
    host: "localhost",
    port: "8080",
    //允许vue项目 用ip访问
    host: '0.0.0.0',
    proxy: {
      '/api' : {
        target: 'http://localhost:9999',
        changeOrigin: true,
        ws: false,
        //剔除掉请求到后台时的 /api 前缀
        pathRewrite: {
          ["^/api"]: ""
        }
      }
    }
  }
})
