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
      </el-menu>
    </el-col>
  </el-row>
</template>

<script>
import {listArticleCategory} from "@/api/article";

export default {
  name: "LeftMenu",
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
      console.log("触发左侧分类点击事件")
      for (const itemKey in this.articleCategory) {
        if (this.articleCategory[itemKey].id == index) {
          this.$emit("callBack", index, this.articleCategory[itemKey].category);
          break;
        }
      }
    }
  }
}
</script>

<style scoped>
  .left-row{
    margin-top: 40px;
  }
</style>
