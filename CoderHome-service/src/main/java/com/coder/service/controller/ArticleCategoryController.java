package com.coder.service.controller;

import com.coder.service.domain.entity.ArticleCategory;
import com.coder.service.service.ArticleCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "文章分类接口")
@RestController
@RequestMapping("/article-category")
public class ArticleCategoryController {
    @Autowired
    private ArticleCategoryService articleCategoryService;

    @ApiOperation("文章分类列表")
    @GetMapping("/list")
    public List<ArticleCategory> listArticleCategory() {
        List<ArticleCategory> list = articleCategoryService.list();
        return list;
    }

    @ApiOperation("添加文章分类")
    @PostMapping("/add")
    public void addArticleCategory(@RequestBody ArticleCategory articleCategory) {
        articleCategoryService.save(articleCategory);
    }
}
