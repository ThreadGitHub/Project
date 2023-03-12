package com.coder.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coder.service.domain.dto.AddArticle;
import com.coder.service.domain.entity.Article;
import com.coder.service.domain.entity.User;
import com.coder.service.mapper.ArticleMapper;
import com.coder.service.service.ArticleService;
import com.coder.service.service.UserSerivce;
import com.coder.service.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService{
    @Autowired
    private UserSerivce userSerivce;

    @Override
    public ResponseUtils addArticle(AddArticle articleDto) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User nowUser = userSerivce.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, userName));
        if (nowUser != null) {
            article.setCreateBy(nowUser.getId());
            article.setCreateTime(new Date());
            this.save(article);
            log.info("增加文章：", article);
            return ResponseUtils.ok();
        } else {
         return ResponseUtils.error("请先登录再写文章");
        }
    }

    @Override
    public ResponseUtils listArticle(Integer articleCategory, Integer count, Integer addNum) {
        List<Article> articles = this.baseMapper.listArticle(articleCategory, count, addNum);
        return ResponseUtils.success(articles);
    }
}
