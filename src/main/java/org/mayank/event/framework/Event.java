package org.mayank.event.framework;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Event
{
    @NonNull
    private String eventId;

    @NonNull
    private String eventType;
}
