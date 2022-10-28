package org.example.queries.calculator.abstraction;

import org.example.model.Person;

@FunctionalInterface
public interface IProvideData {
    Number getData(Person person);
}
