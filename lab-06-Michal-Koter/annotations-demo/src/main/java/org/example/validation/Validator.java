package org.example.validation;

import org.example.SampleObject;
import org.example.validation.rules.ICheckValidationRule;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private List<ICheckValidationRule> rules = new ArrayList<>();

    public <T> ValidationResult<T> validate(T sampleObject) {
        var validationResult = new ValidationResult<T>();
        validationResult.setValidatedObject(sampleObject);
        validationResult.setValid(true);
        for(ICheckValidationRule rule : rules) {
            try {
                rule.validate(validationResult);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return validationResult;
    }

    public Validator addRule(ICheckValidationRule rule) {
        this.rules.add(rule);
        return this;
    }
}
