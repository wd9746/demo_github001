package com.dt.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: springcloud2020
 * @ClassName: ClientConfigController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/5 17:52
 */
@RestController
@RefreshScope
public class ClientConfigController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "serverPort：" + serverPort + "\t\n\n configInfo：" + configInfo;
    }
}
