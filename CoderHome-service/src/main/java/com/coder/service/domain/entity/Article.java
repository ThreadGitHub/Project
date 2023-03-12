package com.coder.service.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@TableName("articles")
@Getter
@Setter
@ToString
public class Article {
    /**
     * 文章id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty("文章id")
    private Integer id;

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

    /**
     * 文章分类id
     */
    @ApiModelProperty("文章分类id")
    private String articleCategory;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Long createBy;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
