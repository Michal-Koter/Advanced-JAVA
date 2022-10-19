package org.example.scheduler;

import org.example.Chron.Chron;
import org.example.Chron.abstractions.IProvideNextExecutionTime;
import org.example.scheduler.abstractions.ICatchException;
import org.example.scheduler.abstractions.IRunNotSafeAction;
import org.example.scheduler.abstractions.IRunSafeAction;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class SchedulerThread implements Runnable{
    @Override
    public void run() {
        Scheduler scheduler = Scheduler.getInstance();
        IProvideNextExecutionTime<Chron> iProvideNextExecutionTime = scheduler.getIProvideNextExecutionTime();
        Chron chron = iProvideNextExecutionTime.provideTime();
        IRunNotSafeAction action = scheduler.getIRunNotSafeAction();
        ICatchException catchException = scheduler.getICatchException();
        IRunSafeAction singleCompleted = scheduler.getSingleActionCompleted();
        IRunSafeAction allCompleted = scheduler.getAllActionCompleted();
        LocalDateTime nextTime = chron.getNextTime();
        LocalDateTime now = LocalDateTime.now();

        while (nextTime != null && (nextTime.isEqual(now) || nextTime.isBefore(now))) {
            try {
                action.executeNotSafeAction();
            } catch (Exception e) {
                catchException.handleException(e);
            }
            singleCompleted.executeSafeAction();
            nextTime = chron.getNextTime();
            now = LocalDateTime.now();
        }
        allCompleted.executeSafeAction();
    }
}
