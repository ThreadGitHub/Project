<template>
  <el-row class="left-row">
    <el-col :span="5"></el-col>
    <el-col :span="17">
      <el-menu
          :default-active="loadMenuType"
          class="left-menu"
          @select="handleOpen"
          @open="menuOpen"
          popper-effect="light"
      >
        <el-menu-item v-for="item in articleCategory" :index="item.id">
          <el-icon><Compass /></el-icon>
          <span type="1">{{item.category}}</span>
        </el-menu-item>

<!--        <el-menu-item index="后端">-->
<!--          <el-icon><CoffeeCup /></el-icon>-->
<!--          <span type="2">后端</span>-->
<!--        </el-menu-item>-->

<!--        <el-menu-item index="前端">-->
<!--          <el-icon><Monitor /></el-icon>-->
<!--          <span type="3">前端</span>-->
<!--        </el-menu-item>-->
<!--        <el-menu-item index="开发工具">-->
<!--          <el-icon><Setting /></el-icon>-->
<!--          <span type="4">开发工具</span>-->
<!--        </el-menu-item>-->
      </el-menu>
    </el-col>
  </el-row>
</template>

<script>
import {listArticleCategory} from "@/api/page";

export default {
  name: "Left",
  mounted() {
    listArticleCategory().then(res=> {
      if (res.data.length > 0) {
        this.articleCategory = res.data;
        this.loadMenuType = res.data[0].id;
        this.handleOpen(this.loadMenuType);
      }
    });
  },
  data(){
    return {
      loadMenuType: '',
      articleCategory: []
    }
  },
  methods: {
    handleOpen(index, indexPath, item, routeResult) {
      this.$emit("callBack", index);
    }
  }
}
</script>

<style scoped>
  .left-row{
    margin-top: 40px;
  }
</style>
