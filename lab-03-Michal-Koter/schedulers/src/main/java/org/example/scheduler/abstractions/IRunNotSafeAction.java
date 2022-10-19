package org.example.scheduler.abstractions;

@FunctionalInterface
public interface IRunNotSafeAction {
    void executeNotSafeAction() throws Exception;
}
