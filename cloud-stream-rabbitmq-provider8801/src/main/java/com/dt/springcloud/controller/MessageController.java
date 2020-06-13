package com.dt.springcloud.controller;

import com.dt.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: springcloud2020
 * @ClassName: MessageController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/6 11:45
 */
@RestController
public class MessageController {

    @Autowired
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String send(){
        return messageProvider.send();
    }
}
