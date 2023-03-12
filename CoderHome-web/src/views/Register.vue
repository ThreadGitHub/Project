<template>
  <el-row>
    <el-col :span="6" :offset="8" style="margin-top: 20vh">
      <el-row>
        <el-col style="text-align: center">
          <h1 style="color: dodgerblue">Coder用户注册</h1>
        </el-col>
      </el-row>
      <el-row>
        <el-col>
          <el-form
              :label-position="alignType"
              label-width="100px"
              :model="formData"
              style="max-width: 460px"
          >
            <el-form-item label="用户名">
              <el-input v-model="formData.userName" />
            </el-form-item>
            <el-form-item label="密码">
              <el-input show-password v-model="formData.password" />
            </el-form-item>
            <el-form-item label="确认密码">
              <el-input show-password v-model="formData.password2" />
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
      <el-row>
        <el-col style="text-align: center">
          <el-button size="default" type="primary" @click="registerFunc">注册</el-button>
          <el-button size="default" @click="cancel">取消</el-button>
        </el-col>
      </el-row>

    </el-col>
  </el-row>
</template>

<script>
import router from "@/router";
import {ElMessage} from "element-plus";
import {register} from "@/api/user";

export default {
  name: "Register",
  data() {
    return {
      formData:{
        userName: '',
        password: '',
        password2: ''
      },
      alignType: 'left'
    };
  },
  methods: {
    registerFunc() {
      register(this.formData).then(res => {
        if (res.data.code == '200') {
          ElMessage({
            showClose: true,
            message: "注册成功",
            type: 'success'
          })
          router.push("/")
        }
      }).catch(errr => {
        ElMessage({
          showClose: true,
          message: errr,
          type: 'warning'
        })
      })
    },
    cancel() {
      router.push("/");
    }
  }
}
</script>

<style scoped>

</style>
