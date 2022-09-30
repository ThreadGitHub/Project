<template>
    <el-container>
      <el-header>Head</el-header>
      <el-container style="height: 80%;">
        <el-aside>Left</el-aside>
        <el-main>Main</el-main>
      </el-container>
      <el-footer>footer</el-footer>
    </el-container>
</template>

<script>
export default {
  name: "Index",
  data () {
    return {
      text: 'test'
    };
  }
}
</script>

<style scoped>
  .el-container {
    height: 100%;
  }
  .el-header {
    height: 10%;
    padding: 0;
    background-color: cornflowerblue;
  }
  .el-aside {
    width: 20%;
    float: left;
    height: 100%;
    background-color: aquamarine;
  }
  .el-main {
    width: 80%;
    height: 100%;
    background-color: chocolate;
  }
  .el-footer {
    width: 100%;
    height: 10%;
    background-color: darkorange;
  }
</style>
