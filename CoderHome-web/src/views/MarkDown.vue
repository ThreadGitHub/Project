<template>
<!--顶部导航条-->
  <el-page-header @back="goBack" title="返回首页" style="margin-bottom: 15px;">
    <template #content>
      <el-row style="width: 70vh">
        <el-col :span="20">
          <el-input type="text" placeholder="文章标题" v-model="formData.articleName"></el-input>
        </el-col>
        <el-col :span="3" style="margin-left: 5px">
          <el-button type="success" @click="showDialog">保存文章</el-button>
        </el-col>
      </el-row>
    </template>
  </el-page-header>

<!--  MarkDown编辑器-->
  <v-md-editor v-model="formData.articleContent" height="90vh"></v-md-editor>

<!--  保存文章弹窗-->
  <el-dialog v-model="dialogFormVisible" title="保存文章" :show-close="false" width="40%"
             draggable="true" :close-on-click-modal="false"
  >
    <el-form :model="formData" style="width: 80%;margin-left: 10%">
      <el-form-item label="文章标题">
        <el-input v-model="formData.articleName"/>
      </el-form-item>
      <el-form-item label="文章分类">
        <el-select placeholder="选择分类" filterable v-model="formData.articleCategory" style="width: 100%">
          <el-option v-for="item in articleCategorys" :label="item.category" :value="item.id" />
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false; formData.articleCategory=''">取消</el-button>
        <el-button type="primary" @click="saveArticle">
          提交
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script>
import router from "@/router";
import {addArticle, listArticleCategory} from "@/api/article";
import {ElMessage} from "element-plus";

export default {
  name: "MarkDown",
  mounted() {
    //打开页面加载文章类别列表数据
    listArticleCategory().then(res => {
      this.articleCategorys = res.data;
    });
  },
  data () {
    return {
      //保存弹窗是否显示
      dialogFormVisible: false,
      //保存的内容
      formData: {
        //文章分类id
        articleCategory: '',
        //文章标题
        articleName: '',
        //markdown内容
        articleContent: ''
      },
      articleCategorys: []
    }
  },
  methods: {
    /**
     * 返回主页
     */
    goBack() {
      router.push("/");
    },
    /**
     * 显示保存弹窗
     */
    showDialog() {
      this.dialogFormVisible = !this.dialogFormVisible;
    },
    validForm() {
      if (this.formData.articleContent.trim() == "") {
        ElMessage({
          message: '保存失败，请填写文章内容',
          type: 'warning',
        })
        return false;
      }
      if (this.formData.articleName.trim() == "") {
        ElMessage({
          message: '保存失败，请填写文章标题',
          type: 'warning',
        })
        return false;
      }
      if (this.formData.articleCategory == "") {
        ElMessage({
          message: '保存失败，选择文章分类',
          type: 'warning',
        })
        return false;
      }
      return true;
    },
    /**
     * 保存文章
     */
    saveArticle() {
      if (!this.validForm()) {
        return;
      }
      addArticle(this.formData).then(res => {
        if (res.data.code == '200') {
          ElMessage({
            message: '文章添加成功 !',
            type: 'success'
          })
          this.dialogFormVisible = false;
        }
      }).catch(error => {
        ElMessage({
          message: '文章添加失败，请检查!\n' + error,
          type: 'error'
        })
      })
    }
  }
}
</script>

<style scoped>

</style>
