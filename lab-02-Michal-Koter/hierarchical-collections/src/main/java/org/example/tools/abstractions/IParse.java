package org.example.tools.abstractions;

import java.util.List;

public interface IParse <TResult> {
    public TResult parse(String line);
}
