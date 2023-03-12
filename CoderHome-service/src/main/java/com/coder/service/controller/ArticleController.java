package com.coder.service.controller;

import com.coder.service.domain.dto.AddArticle;
import com.coder.service.domain.entity.Article;
import com.coder.service.service.ArticleService;
import com.coder.service.utils.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "文章列表")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation("增加文章")
    @PreAuthorize("hasAuthority('system:homepage')")
    @PostMapping
    public ResponseUtils addArticle(@RequestBody AddArticle article) {
        return articleService.addArticle(article);
    }

    @ApiOperation("文章列表")
    @GetMapping
    public ResponseUtils<List<Article>> listArticle(Integer articleCategory, Integer count, Integer addNum) {
        return articleService.listArticle(articleCategory, count, addNum);
    }
}
