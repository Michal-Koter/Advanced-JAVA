package org.example.queries.filter;

import org.example.model.Person;
import org.example.queries.filter.abstraction.IFilterPeople;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class ByAgeFromFilter implements IFilterPeople {
    private SearchParameters searchParameters;

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters=searchParameters;
    }

    @Override
    public boolean canFilter() {
        return searchParameters.getAgeFrom() > 0;
    }

    @Override
    public List<Person> filter(List<Person> listOfPerson) {
        return listOfPerson.stream()
                .filter(p->p.getAge() >= searchParameters.getAgeFrom())
                .toList();
    }
}
