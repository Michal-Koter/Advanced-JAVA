package org.example.scheduler;

import org.example.Chron.Chron;
import org.example.Chron.abstractions.IProvideNextExecutionTime;
import org.example.scheduler.abstractions.ICatchException;
import org.example.scheduler.abstractions.IRunNotSafeAction;
import org.example.scheduler.abstractions.IRunSafeAction;

public class SchedulerBuilder {
    IRunNotSafeAction iRunNotSafeAction;
    IProvideNextExecutionTime<Chron> iProvideNextExecutionTime;
    ICatchException iCatchException = (e)->{};
    IRunSafeAction singleActionCompleted = ()->{};
    IRunSafeAction allActionCompleted = ()->{};

    public SchedulerBuilder forAction(IRunNotSafeAction iRunNotSafeAction) {
        this.iRunNotSafeAction = iRunNotSafeAction;
        return this;
    }

    public SchedulerBuilder useExecutionTimeProvider(IProvideNextExecutionTime<Chron> iProvideNextExecutionTime) {
        this.iProvideNextExecutionTime = iProvideNextExecutionTime;
        return this;
    }

    public SchedulerBuilder onError(ICatchException ex) {
        this.iCatchException = ex;
        return this;
    }

    public SchedulerBuilder onSingleActionCompleted(IRunSafeAction singleActionCompleted) {
        this.singleActionCompleted = singleActionCompleted;
        return this;
    }

    public SchedulerBuilder onCompleted(IRunSafeAction allActionCompleted) {
        this.allActionCompleted = allActionCompleted;
        return this;
    }

    public void schedule() {
        Scheduler scheduler = Scheduler.getInstance();
        scheduler.setIRunNotSafeAction(iRunNotSafeAction);
        scheduler.setICatchException(iCatchException);
        scheduler.setIProvideNextExecutionTime(iProvideNextExecutionTime);
        scheduler.setSingleActionCompleted(singleActionCompleted);
        scheduler.setAllActionCompleted(allActionCompleted);
    }
}
