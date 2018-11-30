package com.example.swaggerstarter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@ApiModel(description = "用户基本信息")
public class User {
    private Long id;

    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    @Max(120)
    @Min(18)
    private Integer age;
}
