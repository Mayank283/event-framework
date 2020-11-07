package org.mayank.event.framework.autoconfigure.messaging;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "event.framework.messaging.rabbitmq")
public class RabbitMQMessagingAutoConfiguration
{
}
