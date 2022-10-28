package org.example.queries.calculator.abstraction;

import org.example.model.Person;
import org.example.queries.search.FunctionsParameters;

import java.util.List;

public interface ICalculate {
    double calculate(FunctionsParameters functionsParameters, List<Person> listOfPerson);
}
