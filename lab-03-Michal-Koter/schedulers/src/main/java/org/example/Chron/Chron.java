package org.example.Chron;

import java.time.Duration;
import java.time.LocalDateTime;

public class Chron {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int maxExecutionTime;
    private Duration intervalDuration;
    private LocalDateTime nextTime;
    private int counter = 0;

    public static ChronBuilder builder() {
        return new ChronBuilder();
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getMaxExecutionTime() {
        return maxExecutionTime;
    }

    public void setMaxExecutionTime(int maxExecutionTime) {
        this.maxExecutionTime = maxExecutionTime;
    }

    public Duration getIntervalDuration() {
        return intervalDuration;
    }

    public void setIntervalDuration(Duration intervalDuration) {
        this.intervalDuration = intervalDuration;
    }

    public LocalDateTime getNextTime() {
        if(startTime==null && endTime==null && nextTime==null){
            nextTime = LocalDateTime.now();
        }else if (nextTime != null && endTime != null) {
            if (counter > maxExecutionTime || nextTime.isAfter(endTime)) {
                return null;
            }
            if (counter == 0 && startTime != null) {
                counter ++;
                return startTime;
            }
            nextTime = nextTime.plus(intervalDuration);
        } else if (counter == 0) {
            nextTime = LocalDateTime.now();
        } else {
            return null;
        }
        counter++;
        return nextTime;
    }
}
