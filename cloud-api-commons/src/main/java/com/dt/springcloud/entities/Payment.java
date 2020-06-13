package com.dt.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  主实体
 */
@Data//生成getter,setter等函数
@AllArgsConstructor//生成全参数构造函数
@NoArgsConstructor//创建一个无参构造函数
public class Payment implements Serializable {

    private Long id;
    private String serial;
}
