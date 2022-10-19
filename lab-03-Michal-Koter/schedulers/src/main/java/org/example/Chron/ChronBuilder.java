package org.example.Chron;

import org.example.Chron.abstractions.IProvideNextExecutionTime;

import java.time.Duration;
import java.time.LocalDateTime;

public class ChronBuilder {
    LocalDateTime start, end;
    int maxExecution;
    Duration interval;

    public ChronBuilder setStartTime(LocalDateTime start){
        this.start = start;
        return this;
    }

    public ChronBuilder setEndDate(LocalDateTime end){
        this.end = end;
        return this;
    }

    public ChronBuilder setMaxExecutionTimes(int max) {
        this.maxExecution = max;
        return this;
    }

    public ChronBuilder setIntervalDuration(Duration interval) {
        this.interval = interval;
        return  this;
    }

    public IProvideNextExecutionTime<Chron> buildNextExecutionTimeProvider() {
        return () -> {
            Chron chron = new Chron();
            chron.setStartTime(start);
            chron.setEndTime(end);
            chron.setMaxExecutionTime(maxExecution);
            chron.setIntervalDuration(interval);
            return chron;
        };
    }
}
