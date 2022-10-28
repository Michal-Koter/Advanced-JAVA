package org.example.queries;

import org.example.model.Person;
import org.example.queries.calculator.abstraction.ICalculate;
import org.example.queries.filter.abstraction.IFilterPeople;
import org.example.queries.page.abstraction.ICutToPage;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.Page;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class QueryProcessor {
    private List<IFilterPeople> filters = new ArrayList<>();
    private Map<String,ICalculate> calculates = new TreeMap<>();
    private ICutToPage pageCutter;

    public QueryProcessor addFilter(IFilterPeople filter) {
        filters.add(filter);
        return this;
    }

    public QueryProcessor addCalculation(String key, ICalculate value) {
        calculates.put(key, value);
        return this;
    }

    public void addPageCutter(ICutToPage iCut) {
        this.pageCutter = iCut;
    }

    public Results GetResults(SearchParameters parameters, List<Person> data){
        Results results = new Results();

        results.setItems(filterResult(parameters, data));

        results.setFunctionResults(calculateFunctions(parameters,data));

        results.setCurrentPage(pageCutter.cut(parameters.getPage(),data).size());

        results.setPages(countPages(parameters.getPage(),data));

        return results;
    }

    private List<Person> filterResult(SearchParameters parameters, List<Person> data) {
        for(IFilterPeople filterPeople : filters) {
            filterPeople.setSearchParameters(parameters);
            if (filterPeople.canFilter()) {
                data = filterPeople.filter(data);
            }
        }
        return data;
    }

    private List<FunctionResult> calculateFunctions(SearchParameters parameters, List<Person> data) {
        List<FunctionResult> functionResults = new ArrayList<>();
        double value;
        for (FunctionsParameters param: parameters.getFunctions()) {
            value = calculates
                    .get(param.getFieldName())
                    .calculate(param,data);
            FunctionResult fResult = new FunctionResult();
            fResult.setFieldName(param.getFieldName());
            fResult.setFunction(param.getFunction());
            fResult.setValue(value);
            functionResults.add(fResult);
        }
        return functionResults;
    }

    private int countPages(Page page, List<Person> data) {
        int counter = 0;
        int onSinglePage = page.getSize();
        int amountItems = data.size();
        while (amountItems>onSinglePage) {
            amountItems -= onSinglePage;
            counter++;
        }
        return counter;
    }
}
