package luiz787.pocws.core;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class SampleMessage {
    Status status;
    String description;
    LocalDateTime dateTime;
}
