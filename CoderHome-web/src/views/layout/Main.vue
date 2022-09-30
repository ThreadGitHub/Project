<template>
  <h1>Main</h1>
  <el-button @click="openUrl()">打开百度</el-button>
</template>

<script>
export default {
  name: "Main",
  methods: {
    openUrl() {
      window.open("https://www.baidu.com");
    }
  }
}
</script>

<style scoped>

</style>
