package org.example.queries.filter;

import org.example.model.Person;
import org.example.queries.filter.abstraction.DualPredicate;
import org.example.queries.filter.abstraction.IFilterPeople;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.function.Predicate;

public class GeneralFilter implements IFilterPeople {
    private SearchParameters searchParameters;
    private final Predicate<SearchParameters> canFilterPredicate;
    private final DualPredicate<SearchParameters,Person> filterPredicate;

    public GeneralFilter(Predicate<SearchParameters> predicate, DualPredicate<SearchParameters, Person> dualPredicate) {
        this.canFilterPredicate = predicate;
        this.filterPredicate = dualPredicate;
    }

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public boolean canFilter() {
        return canFilterPredicate.test(this.searchParameters);
    }

    @Override
    public List<Person> filter(List<Person> listOfPeople) {
        return listOfPeople.stream()
                .filter(person -> filterPredicate.check(searchParameters,person))
                .toList();
    }
}
