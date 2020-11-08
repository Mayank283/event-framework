package org.mayank.event.framework.autoconfigure.event;

import org.mayank.event.framework.messaging.service.RabbitMQMessagingService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mayankagarwal
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({RabbitTemplate.class})
@ConditionalOnProperty(name = "event.framework.messaging.rabbitmq", havingValue = "true", matchIfMissing = true)
public class RabbitMQMessagingConfiguration
{
    @Bean
    @ConditionalOnMissingBean({RabbitMQMessagingService.class})
    public RabbitMQMessagingService rabbitMQMessagingService()
    {
        return new RabbitMQMessagingService();
    }
}
