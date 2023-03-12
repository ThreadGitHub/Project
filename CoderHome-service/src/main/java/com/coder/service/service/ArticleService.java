package com.coder.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.coder.service.domain.dto.AddArticle;
import com.coder.service.domain.entity.Article;
import com.coder.service.utils.ResponseUtils;

public interface ArticleService extends IService<Article> {
    /**
     * 增加文章
     * @param article
     * @return
     */
    ResponseUtils addArticle(AddArticle article);

    /**
     * 查询文章列表
     * @param count
     * @param addNum
     * @return
     */
    ResponseUtils listArticle(Integer articleCategory, Integer count, Integer addNum);
}
