package org.example.queries.filter;

import org.example.model.Person;
import org.example.queries.filter.abstraction.IFilterPeople;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class ByNameFilter implements IFilterPeople {
    private SearchParameters searchParameters;

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public boolean canFilter() {
        try {
            return !searchParameters.getName().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Person> filter(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .filter(p->p.getName().equalsIgnoreCase(searchParameters.getName()))
                .toList();

    }
}
