<template>
  <div class="head-container">
    <el-row class="header-row">
      <el-col class="head-title-col" :span="14">
        <span class="head-title">CoderHome</span>
      </el-col>
      <el-col :span="4" style="padding-top: 10px;">
        <el-input placeholder="查询" suffix-icon="Search"/>
      </el-col>

      <el-col :span="6">
        <el-row style="height: 100%;width: 100%;">
          <el-col class="avatar-col" :span="6" style="text-align: center;padding-top: 10px;">
            <el-avatar src="https://avatars.githubusercontent.com/u/32630294?s=400&u=288cd0ed64989013bd40446a5ceb387e275021c5&v=4"/>
          </el-col>
          <el-col :span="5" style="padding-top: 10px;">
            <el-button color="#626aef" @click="loginFunc()">登录</el-button>
          </el-col>
          <el-col :span="5" style="padding-top: 10px;height: 100%;width: 100%">
            <el-button>注册</el-button>
          </el-col>
          <el-col :span="5" style="padding-top: 10px;">
            <el-button @click="openMD()" type="success">写文章</el-button>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "Head",
  methods: {
    loginFunc(){
      router.push("/login")
    },
    openMD() {
      router.push("/md")
    }
  }
}
</script>

<style scoped>
 .head-title-col {
   padding-top: 14px;
   padding-left: 20px;
 }
 .head-title{
   font-family: 宋体;
   font-size: 25px;
 }
  .head-container {
    width: 100%;
    height: 100%;
    background-color: white;
  }
  .header-row {
    border-bottom: 1px solid #dcdfe6;
    height: 100%;
  }
</style>
