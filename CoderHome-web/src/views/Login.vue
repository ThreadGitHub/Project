<template>
  <div class="login">
    <el-form ref="loginForm" :model="loginForm">
      <h3>CoderHome用户登录</h3>
      <el-item prop="userName">
        <el-input v-model="loginForm.userName" type="text"
                  auto-complete="off"
                  placeholder="请输入账号">
        </el-input>

      </el-item>
      <el-item prop="password">
        <el-input v-model="loginForm.password" type="password"
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
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        userName: "",
        password: "",
        rememberMe: false
      },
      loading: false
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
</style>
