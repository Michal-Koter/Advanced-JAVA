package org.example.simpleMethod.abstraction;

import java.lang.reflect.Method;

public interface IMethodFacade {
    boolean isPublic();
    boolean paramsCountEquals(int number);
    boolean startsWith(String string);
    boolean isVoid();
    boolean isSetter();
    boolean isGetter();
    String getFieldName();
    Method GetUnderlyingMethod();
}
