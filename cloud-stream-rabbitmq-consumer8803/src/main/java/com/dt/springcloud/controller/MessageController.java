package com.dt.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @ProjectName: springcloud2020
 * @ClassName: MessageController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/6 22:04
 */
@Controller
@EnableBinding(Sink.class)
public class MessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者2号，接受" + message.getPayload() + "\t serverPort：" + serverPort);
    }
}
