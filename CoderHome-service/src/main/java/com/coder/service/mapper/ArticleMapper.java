package com.coder.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coder.service.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 查询文章列表
     * @param articleCategory
     * @param count
     * @param addNum
     * @return
     */
    List<Article> listArticle(Integer articleCategory, Integer count, Integer addNum);
}
