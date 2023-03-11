package com.coder.service.controller;

import com.coder.service.domain.entity.ArticleCategory;
import com.coder.service.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article-category")
public class ArticleCategoryController {
    @Autowired
    private ArticleCategoryService articleCategoryService;

    @GetMapping("/list")
    public List<ArticleCategory> listCArticleCategory() {
        List<ArticleCategory> list = articleCategoryService.list();
        return list;
    }
}
