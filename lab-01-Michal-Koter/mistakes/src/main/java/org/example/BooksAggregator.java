package org.example;

import org.example.model.Book;
import org.example.model.Person;
import org.example.model.Samples;

import java.util.Random;

public class BooksAggregator {

    public void aggregateBooksThroughPeople(){
        for (Person person: Samples.getSampleListOfPeople())
        {
            if(Samples.getAvailableBooks().isEmpty()){
                break;
            }
            int randomIndex = getRandomIndex();
            Book book = Samples.getAvailableBooks().get(randomIndex);
            person.getBooks().add(book);
            Samples.removeFromAvailable(randomIndex);

            int bookIndex = Samples.getAllBooks().indexOf(book);
            Samples.getAllBooks().get(bookIndex).setOwner(person);

        }
    }
    private int getRandomIndex(){
        return new Random().nextInt(Samples.getAvailableBooks().size());
    }


}
