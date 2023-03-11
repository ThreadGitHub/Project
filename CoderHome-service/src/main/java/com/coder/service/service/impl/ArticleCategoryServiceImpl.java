package com.coder.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.service.domain.entity.ArticleCategory;
import com.coder.service.mapper.ArticleCategoryMapper;
import com.coder.service.service.ArticleCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<ArticleCategoryMapper, ArticleCategory>
        implements ArticleCategoryService {

}
