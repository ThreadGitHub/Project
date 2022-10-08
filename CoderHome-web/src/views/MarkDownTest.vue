<template>
  <div style="width: 100%;height:100%">
    <div style="width: 100%;height:5vh;">
      <el-page-header @back="goBack" title="返回首页">
        <template #content>
          写文章
        </template>
      </el-page-header>
    </div>
    <v-md-editor v-model="text" height="90vh"></v-md-editor>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "MarkDownTest",
  data () {
    return {
      text: ''
    }
  },
  methods: {
    goBack() {
      router.push("/");
    }
  }
}
</script>

<style scoped>
  /*.el-page-header__breadcrumb {*/
  /*  margin-bottom: 0 !important;*/
  /*}*/
  /*.el-page-header {*/
  /*  padding-top: 10px;*/
  /*}*/
</style>