<template>
  <h1>Main</h1>
  <el-button @click="openUrl()">打开百度</el-button>
</template>

<script>
import request from "@/utils/request";
import {baidu} from "@/api/user";

export default {
  name: "Main",
  methods: {
    openUrl() {
      baidu().then(res => {
        console.log(res)
      }).catch(error => {
        console.log(error)
      })
    }
  }
}
</script>

<style scoped>

</style>
