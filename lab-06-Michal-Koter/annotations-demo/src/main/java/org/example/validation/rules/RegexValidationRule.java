package org.example.validation.rules;

import org.example.validation.ValidationResult;
import org.example.validation.annotations.Regex;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidationRule implements ICheckValidationRule{
    @Override
    public <T> void validate(ValidationResult<T> result){
        Class<?> clazz = result.getValidatedObject().getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Regex.class)) {
                var regex = field.getAnnotation(Regex.class);
                field.setAccessible(true);
                try {
                    Pattern pattern = Pattern.compile(regex.pattern());
                    Matcher matcher = pattern.matcher((CharSequence) field.get(result.getValidatedObject()));
                    if (!matcher.find()) {
                        result.setValid(false);
                        result.getNotValidFields().get(field.getName()).add(regex.message());
                    }
                } catch (NullPointerException e) {
                    result.getNotValidFields().put(field.getName(), Collections.singletonList(regex.message()));
                } catch (IllegalAccessException ignore) {
                }
            }
        }
    }
}
