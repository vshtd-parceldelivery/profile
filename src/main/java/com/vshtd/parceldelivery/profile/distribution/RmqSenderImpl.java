package com.vshtd.parceldelivery.profile.distribution;

import com.vshtd.parceldelivery.profile.model.mqo.CreateProfileMQO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RmqSenderImpl implements RmqSender {

    @Value("${rabbitmq.create-profile.rk}")
    private String trackOrderRk;

    @Autowired
    private Exchange createProfileExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void createProfile(CreateProfileMQO profile) {
        log.info("RMQ sending | create profile | username: {} | ex: {}",
                profile.getUsername(), createProfileExchange.getName());
        rabbitTemplate.convertAndSend(createProfileExchange.getName(), trackOrderRk, profile);
    }
}
