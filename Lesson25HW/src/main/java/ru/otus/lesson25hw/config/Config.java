package ru.otus.lesson25hw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Configuration
public class Config {
    @Bean
    public MessageChannel channel() {
        return MessageChannels.direct("dChanel").get();
    }
    @Bean
    public IntegrationFlow userFlow() {
        return f -> f
                .channel("dChanel")
                .log()
                .channel(MessageChannels.direct())
                .log()
                .channel(MessageChannels.publishSubscribe())
                .split()
                .aggregate();
    }
}
