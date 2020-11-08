package org.mayank.event.framework.autoconfigure.event;

import org.mayank.event.framework.publisher.DefaultEventPublisher;
import org.mayank.event.framework.publisher.EventPublisher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author mayankagarwal
 */
@Configuration
@EnableConfigurationProperties(EventProperties.class)
@Import({KafkaMessagingConfiguration.class, RabbitMQMessagingConfiguration.class})
public class EventFrameworkAutoConfiguration
{
    @Bean
    @ConditionalOnMissingBean({EventPublisher.class})
    public DefaultEventPublisher eventPublisher()
    {
        return new DefaultEventPublisher();
    }
}
