<template>
  <h1>Main</h1>
  <el-button @click="openUrl()">打开百度</el-button>
  <el-button @click="openAdmin()">测试管理员登录授权</el-button>
  <el-button @click="openUser()">测试普通用户登录授权</el-button>
</template>

<script>
import request from "@/utils/request";
import {baidu} from "@/api/user";
import {ElMessage} from "element-plus";

export default {
  name: "Main",
  methods: {
    openUrl() {
      baidu().then(res => {
        console.log(res)
      }).catch(error => {
        console.log(error)
      })
    },
    showMsg(message) {
      ElMessage({
        showClose: true,
        message: message,
        type: 'success'
      })
    },
    openAdmin () {
      request({
        url: '/api/test/admin',
        method: 'get'
      }).then(res => {
        this.showMsg(res.data)
      }).catch(err => {
        this.showMsg('无权请登录 ' + err)
      });
    },
    openUser() {
      request({
        url: '/api/test/user',
        method: 'get'
      }).then(res => {
        this.showMsg(res.data)
      }).catch(err => {
        this.showMsg('无权请登录 ' + err)
      });
    }
  }
}
</script>

<style scoped>

</style>
