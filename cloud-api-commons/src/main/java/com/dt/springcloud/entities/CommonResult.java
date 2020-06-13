package com.dt.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  json 封装体
 */
@Data//生成getter,setter等函数
@AllArgsConstructor//生成全参数构造函数
@NoArgsConstructor//创建一个无参构造函数
public class CommonResult<T> {

    private Integer core;//状态码
    private String message;//错误消息
    private T data;

    public CommonResult(Integer core, String message){
        this.core=core;
        this.message=message;
    }
}
