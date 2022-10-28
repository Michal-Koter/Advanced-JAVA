package org.example.queries.filter.abstraction;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;


public interface IFilterPeople {
    void setSearchParameters(SearchParameters searchParameters);
    boolean canFilter();
    List<Person> filter(List<Person> listOfPerson);
}
