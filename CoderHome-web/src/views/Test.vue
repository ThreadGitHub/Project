<template>
  <el-row justify="center" align="middle">
    <el-col :offset="15">
      <h1>测试路由页面</h1>
    </el-col>
    <el-col :offset="15">
      <el-button @click="openUrl">打开百度</el-button>
      <el-button @click="openAdmin">测试管理员登录授权</el-button>
      <el-button @click="openUser">测试普通用户登录授权</el-button>
      <el-button @click="openTest">测试获取用户</el-button>
    </el-col>
  </el-row>
</template>

<script>
import {baidu} from "@/api/user";
import {ElMessage} from "element-plus";
import request from "@/utils/request";

export default {
  name: "Test",
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
    },
    openTest() {
      request({
        url: '/api/test/hello',
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
  .el-row {
    height: 100%;
  }
</style>
