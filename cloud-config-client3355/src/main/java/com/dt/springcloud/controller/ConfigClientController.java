package com.dt.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: springcloud2020
 * @ClassName: ConfigClientController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/5 15:33
 */
@RestController
@RefreshScope //配置文件自动刷新
public class ConfigClientController {

    @Value("${config.info}")//引入配置
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
