package org.todolist.domain.service;
import java.time.Duration;
import java.time.LocalDateTime;

public class DateService {
    public String getElapsedTime(LocalDateTime fromDateTime) {
        Duration duration = Duration.between(fromDateTime, LocalDateTime.now());
        if (duration.toDays() > 0) {
            return duration.toDays() + " days";
        } else if (duration.toHours() > 0) {
            return duration.toHours() + " hours";
        } else {
            return duration.toMinutes() + " minutes";
        }
    }
}
