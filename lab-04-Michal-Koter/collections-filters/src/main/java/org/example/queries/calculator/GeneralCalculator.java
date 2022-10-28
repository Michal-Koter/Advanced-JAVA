package org.example.queries.calculator;

import org.example.model.Person;
import org.example.queries.calculator.abstraction.ICalculate;
import org.example.queries.calculator.abstraction.IProvideData;
import org.example.queries.search.FunctionsParameters;

import java.util.List;

public class GeneralCalculator implements ICalculate {
    private final String name;
    private final IProvideData provideData;

    public GeneralCalculator(String name, IProvideData provideData) {
        this.name= name;
        this.provideData = provideData;
    }

    @Override
    public double calculate(FunctionsParameters functionsParameters,  List<Person> listOfPerson) {
        double result;
        switch (functionsParameters.getFunction()) {
            case SUM -> result = listOfPerson.stream()
                    .mapToDouble(p -> provideData.getData(p).doubleValue())
                    .sum();
            case AVERAGE -> result = listOfPerson.stream()
                    .mapToDouble(p -> provideData.getData(p).doubleValue())
                    .average()
                    .orElse(-1);
            case MAX -> result = listOfPerson.stream()
                    .mapToDouble(p -> provideData.getData(p).doubleValue())
                    .max()
                    .orElse(-1);
            case MIN -> result = listOfPerson.stream()
                    .mapToDouble(p -> provideData.getData(p).doubleValue())
                    .min()
                    .orElse(-1);
            default -> result = -1;
        }
        return result;
    }
}
