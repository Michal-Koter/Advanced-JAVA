package org.example.simpleClass.abstraction;

import org.example.simpleMethod.abstraction.IMethodFacade;

import java.lang.reflect.Field;
import java.util.List;

public interface IClassFacade {
    List<IMethodFacade> getPublicDeclaredMethods();
    List<IMethodFacade> getPublicGetters();
    List<IMethodFacade> getPublicSetters();
    List<Field> getFieldsForPublicProperties();
}
