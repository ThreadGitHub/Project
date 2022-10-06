const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 设置vue服务器代理后台服务地址
  devServer: {
    host: "localhost",
    port: "8080",
    proxy: {
      '/api' : {
        target: 'http://localhost:9999',
        changeOrigin: true,
        ws: false
      }
    }
  }
})
