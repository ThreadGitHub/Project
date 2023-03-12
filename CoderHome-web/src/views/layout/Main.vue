<template>
  <el-row>
    <el-col :span="10">
      <ul class="infinite-list">
        <li v-for="item in articles" class="infinite-list-item">文章：{{item.articleName}}</li>
      </ul>
    </el-col>
  </el-row>
</template>

<script>
import {ElMessage} from "element-plus";
import {listArticle} from "@/api/article";

export default {
  name: "Main",
  data() {
    return {
      count : 0,
      addNum: 2,
      articleCategory: '',
      articles: []
    }
  },
  props:{
    pageType: String,
    pageName: String
  },
  watch:{
    pageType(newVal, oldVal) {
      this.count = 0;
      this.articles = [];
      if (newVal != '') {
        //设置选中的文章类型
        this.articleCategory = newVal;
        //加载文章列表
        this.load();
      }
    }
  },
  methods: {
    /**
     * 加载文章列表
     */
    load() {
      console.log(this.count + "\t" + this.addNum + "\t" + this.articleCategory)
      this.listArticles(this.articleCategory, this.count, this.addNum)
    },
    /**
     * 加载文章列表数据
     * @param articleCategory
     * @param count
     * @param addNum
     */
    listArticles(articleCategory, count, addNum) {
      listArticle(articleCategory, count, addNum).then(res => {
        if (res.data.code == '200') {
          let articleArray = res.data.data;
          if (articleArray.length > 0) {
            console.log("..........")
            this.articles.push(...res.data.data);
            console.log(this.articles)
            //之后每次递增5条
            this.count += addNum;
          }
        }
      }).catch(error => {
        ElMessage({
          showClose: true,
          message: error,
          type: 'error'
        })
      })
    }
  }
}
</script>

<style scoped>
  .infinite-list {
    padding: 0;
    margin: 0;
    list-style: none;
  }
  .infinite-list .infinite-list-item {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 120px;
    background: var(--el-color-primary-light-9);
    margin: 10px;
    color: var(--el-color-primary);
  }
  .infinite-list .infinite-list-item + .list-item {
    margin-top: 10px;
  }
</style>
