package org.mayank.event.framework.autoconfigure.event;

import org.mayank.event.framework.messaging.service.KafkaMessagingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author mayankagarwal
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({KafkaTemplate.class})
@ConditionalOnProperty(name = "event.framework.messaging.kafka", havingValue = "true", matchIfMissing = true)
public class KafkaMessagingConfiguration
{
    @Bean
    @ConditionalOnMissingBean({KafkaMessagingService.class})
    public KafkaMessagingService kafkaMessagingService()
    {
        return new KafkaMessagingService();
    }
}
