<template>
  <el-container>
    <el-header>
      <Head></Head>
    </el-header>
    <el-container style="height: 80%;">
      <el-aside>
        <Left></Left>
      </el-aside>
      <el-main>
        <Main></Main>
      </el-main>
    </el-container>
    <el-footer>
      <Footer></Footer>
    </el-footer>
  </el-container>
</template>

<script>
import Footer from "@/views/layout/Footer";
import Main from "@/views/layout/Main";
import Left from "@/views/layout/Left";
import Head from "@/views/layout/Head";

export default {
  name: "Index",
  components: {Head, Left, Main, Footer},
  data() {
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
  height: 7%;
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
  height: 13%;
  background-color: darkorange;
}
</style>
