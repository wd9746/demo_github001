package com.dt.springcloud.service.impl;

import com.dt.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @ProjectName: springcloud2020
 * @ClassName: MessageProviderImpl
 * @Description: TODO(一句话描述该类的功能)
 * @Author: WD
 * @Date: 2020/6/6 11:26
 */
@EnableBinding(Source.class) //定义消息生产者的推送源（管道）
public class MessageProviderImpl implements MessageProvider {

    @Autowired
    private MessageChannel output;//定义消息的发送管道

    @Override
    public String send() {
        String value = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(value).build());
        System.out.println("=>"+value);
        return null;
    }
}
