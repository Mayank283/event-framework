package org.mayank.event.framework.autoconfigure.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author mayankagarwal
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties
public class EventProperties
{
    private Map<String, Topic> event;

    @Getter
    @Setter
    public static class Topic
    {
        private String topicName;
    }
}