package org.example.Chron.abstractions;

@FunctionalInterface
public interface IProvideNextExecutionTime<TItem> {
    TItem provideTime();
}
