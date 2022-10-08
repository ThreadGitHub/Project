<template>
  <el-container>
    <el-header>
      <Head></Head>
    </el-header>
    <el-container style="height: 80vh;">
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
  height: 100vh;
}

.el-header {
  padding:0;
  height: 8vh;
}

.el-footer {
  width: 100%;
  height: 12vh;
}
</style>
