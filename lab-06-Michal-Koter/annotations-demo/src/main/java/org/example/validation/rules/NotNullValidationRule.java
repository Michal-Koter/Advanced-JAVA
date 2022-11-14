package org.example.validation.rules;

import org.example.validation.ValidationResult;
import org.example.validation.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Collections;

public class NotNullValidationRule implements ICheckValidationRule{
    @Override
    public <T> void validate(ValidationResult<T> result){
        Class<?> clazz = result.getValidatedObject().getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                var notNull = field.getAnnotation(NotNull.class);
                field.setAccessible(true);
                try {
                    if (field.get(result.getValidatedObject()) == null) {
                        result.setValid(false);
                        result.getNotValidFields().get(field.getName()).add(notNull.message());
                    }
                } catch (NullPointerException e) {
                    result.getNotValidFields().put(field.getName(), Collections.singletonList(notNull.message()));
                } catch (IllegalAccessException ignore) {
                }
            }
        }
    }
}
