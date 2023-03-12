<template>
  <el-container class="page-content">
    <el-header style="height: 8vh">
      <Head></Head>
    </el-header>
    <el-container style="height: 92vh;">
      <el-aside>
        <Left id="left-contains" @callBack="changePageType"></Left>
      </el-aside>
      <el-main v-infinite-scroll="loadPages" style="overflow: auto">
        <Main v-model:page-type="pageType" v-model:page-name="pageName" ref="main"></Main>
      </el-main>
    </el-container>
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
      text: 'test',
      pageType: '',
      pageName: ''
    };
  },
  methods: {
    /**
     * 左侧菜单列表点击的时候加载右侧文章内容事件
     * @param type
     */
    changePageType(type, name) {
      this.pageType = type;
      this.pageName = name;
    },
    /**
     * 右侧动态加载文章内容
     */
    loadPages() {
      console.log("触发动态加载数据事件")
      this.$refs.main.load();
    }
  }
}
</script>

<style scoped>
.page-content {
  background-color: #f3f6f6;
}
/*去掉Head的左右padding*/
.el-header {
  padding: 0;
}
</style>
