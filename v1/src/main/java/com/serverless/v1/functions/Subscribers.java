package com.serverless.v1.functions;

import com.serverless.v1.Service.SubscriberService;
import com.serverless.v1.model.Subscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Configuration
public class Subscribers {

    private final SubscriberService subscriberService;

    public Subscribers(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @Bean
    public Supplier<List<Subscriber>> findAll(){
        return () -> subscriberService.findAll();
    }

    @Bean
    public Consumer<String> create(){
        return subscriberService::create;
    }
}
