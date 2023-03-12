package com.coder.service.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 新增文章内容dto
 */
@Getter
@Setter
@ToString
public class AddArticle {
    /**
     * 文章分类id
     */
    @ApiModelProperty("文章分类id")
    private String articleCategory;

    /**
     * 文章名称
     */
    @ApiModelProperty("文章名称")
    private String articleName;

    /**
     * 文章内容
     */
    @ApiModelProperty("文章内容")
    private String articleContent;
}
