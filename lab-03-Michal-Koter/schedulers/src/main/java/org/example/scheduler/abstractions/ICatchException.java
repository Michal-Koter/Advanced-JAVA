package org.example.scheduler.abstractions;

@FunctionalInterface
public interface ICatchException {
    void handleException (Exception ex);
}
