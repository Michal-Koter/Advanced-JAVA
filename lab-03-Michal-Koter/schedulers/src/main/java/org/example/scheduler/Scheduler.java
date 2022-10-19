package org.example.scheduler;

import org.example.Chron.Chron;
import org.example.Chron.abstractions.IProvideNextExecutionTime;
import org.example.scheduler.abstractions.ICatchException;
import org.example.scheduler.abstractions.IRunNotSafeAction;
import org.example.scheduler.abstractions.IRunSafeAction;

public class Scheduler {
    private static Scheduler instance;
    private IRunNotSafeAction iRunNotSafeAction;
    private ICatchException iCatchException;
    private IProvideNextExecutionTime<Chron> iProvideNextExecutionTime;
    private IRunSafeAction singleActionCompleted;
    private IRunSafeAction allActionCompleted;

    private Scheduler() {
    }

    public static Scheduler getInstance() {
        if (instance == null) {
            instance = new Scheduler();
        }
        return instance;
    }

    public SchedulerBuilder build() {
        return new SchedulerBuilder();
    }

    public IRunNotSafeAction getIRunNotSafeAction() {
        return iRunNotSafeAction;
    }

    public void setIRunNotSafeAction(IRunNotSafeAction iRunNotSafeAction) {
        this.iRunNotSafeAction = iRunNotSafeAction;
    }

    public IProvideNextExecutionTime<Chron> getIProvideNextExecutionTime() {
        return iProvideNextExecutionTime;
    }

    public void setIProvideNextExecutionTime(IProvideNextExecutionTime<Chron> iProvideNextExecutionTime) {
        this.iProvideNextExecutionTime = iProvideNextExecutionTime;
    }

    public IRunSafeAction getSingleActionCompleted() {
        return singleActionCompleted;
    }

    public void setSingleActionCompleted(IRunSafeAction singleActionCompleted) {
        this.singleActionCompleted = singleActionCompleted;
    }

    public IRunSafeAction getAllActionCompleted() {
        return allActionCompleted;
    }

    public void setAllActionCompleted(IRunSafeAction allActionCompleted) {
        this.allActionCompleted = allActionCompleted;
    }

    public ICatchException getICatchException() {
        return iCatchException;
    }

    public void setICatchException(ICatchException iCatchException) {
        this.iCatchException = iCatchException;
    }
}
