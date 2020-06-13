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
 * @Date: 2020/6/6 21:39
 */
@Controller
@EnableBinding(Sink.class)//指通道channel和exchange绑定在一起
public class MessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT) //监听队列
    public void input(Message<String> message){
        System.out.println("消费者1号，接受"+message.getPayload()+"\t serverPort："+serverPort);
    }
}
