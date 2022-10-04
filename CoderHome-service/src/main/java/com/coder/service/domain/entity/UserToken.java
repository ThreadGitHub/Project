package com.coder.service.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@TableName("user_token")
public class UserToken {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * useid
     */
    @ApiModelProperty("userName")
    private String userName;

    /**
     * token
     */
    @ApiModelProperty("token")
    private String token;
}
