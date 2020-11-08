package org.mayank.event.framework.autoconfigure.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Configuration properties for Event's topic.
 *
 * event topics must be defined in spring application.properties file in below format.
 * {@code event.{name of event}.topic}
 *
 * @author mayankagarwal
 */
@Getter
@Setter
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
