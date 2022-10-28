package org.example.queries.filter.abstraction;

public interface DualPredicate <TItem1, TItem2>{
    boolean check(TItem1 tItem1, TItem2 tItem2);
}
