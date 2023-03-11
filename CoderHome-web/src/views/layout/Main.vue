<template>
  <h1>{{pageType}}</h1>
<!--  <el-button @click="openUrl()">打开百度</el-button>-->
<!--  <el-button @click="openAdmin()">测试管理员登录授权</el-button>-->
<!--  <el-button @click="openUser()">测试普通用户登录授权</el-button>-->
  <el-row>
    <el-col :span="10">
      <ul class="infinite-list">
        <li v-for="i in count" :key="i" class="infinite-list-item">文章：{{ i }}</li>
      </ul>
    </el-col>
  </el-row>

</template>


<script>
import request from "@/utils/request";
import {baidu} from "@/api/user";
import {ElMessage} from "element-plus";

export default {
  name: "Main",
  data() {
    return {
      count : 0
    }
  },
  props:{
    pageType: String
  },
  watch:{
    pageType(newVal, oldVal) {
      console.log("检查到新值：" + newVal)
    }
  },
  methods: {
    load(arg) {
      if (this.count == 0) {
        this.count = 10;
        return;
      }
      this.count+=2;
      console.log(arg)
    },
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
  .infinite-list {
    /*height: 300px;*/
    padding: 0;
    margin: 0;
    list-style: none;
  }
  .infinite-list .infinite-list-item {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 70px;
    background: var(--el-color-primary-light-9);
    margin: 10px;
    color: var(--el-color-primary);
  }
  .infinite-list .infinite-list-item + .list-item {
    margin-top: 10px;
  }
</style>
