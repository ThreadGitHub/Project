package com.coder.service.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

@TableName("article_category")
@ToString
@Getter
@Setter
public class ArticleCategory {
    @ApiModelProperty("文章类别id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("文章类别名称")
    private String category;

    @ApiModelProperty("创建用户")
    private String createBy;

    @ApiModelProperty("创建时间")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    @ApiModelProperty("更新时间")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;

    @ApiModelProperty("备注")
    private String remark;
}
