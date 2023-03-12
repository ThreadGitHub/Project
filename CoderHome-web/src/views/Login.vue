<template>
  <div class="login">
    <el-form ref="loginForm">
      <h2>CoderHome 用户登录</h2>
      <el-item prop="userName">
        <el-input v-model="userName" type="text"
                  auto-complete="off"
                  placeholder="请输入账号">
        </el-input>

      </el-item>
      <el-item prop="password">
        <el-input v-model="password" type="password"
                  auto-complete="off"
                  placeholder="请输入密码">
        </el-input>
      </el-item>
      <el-form-item style="width:100%;">
        <el-button
            :loading="loading"
            size="medium"
            type="primary"
            style="width:100%;"
            @click="loginFunc()"
            @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div style="float: right;" v-if="register">
          <router-link class="link-type" :to="'/register'">立即注册</router-link>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>s

<script>
import {login} from "@/api/user";
import {ElMessage} from "element-plus";
import router from "@/router";

export default {
  name: "Login",
  data() {
    return {
      userName: "",
      password: "",
      loading: false
    }
  },
  methods: {
    loginFunc(){
      login({
        userName: this.userName,
        password: this.password
      }).then(res => {
        let data = res.data
        if (data.code == '200') {
          ElMessage({
            showClose: true,
            message: "登录成功, token: " + data.data.token,
            type: 'success'
          })
          //存入localStorage
          localStorage.setItem("user", data.data.token)
          router.push("/")
        }else{
          ElMessage({
            showClose: true,
            message: data.data,
            type: 'error'
          })
        }
      })
    }
  }
}
</script>

<style scoped>
.login {
  text-align: center;
  background-color: #fff;
  border-radius: 20px;
  width: 300px;
  height: 350px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.el-input {
  margin-bottom: 20px;
}
</style>
