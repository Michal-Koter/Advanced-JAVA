package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Samples {

    private static List<Person> people =List.of(
            new Person("Clark","Kent", Gender.MALE),
            new Person("Lois","Lane", Gender.FEMALE),
            new Person("Slade","Wilson", Gender.MALE),
            new Person("Jessica","Jones", Gender.FEMALE),
            new Person("Bruce","Wayne", Gender.MALE),
            new Person("Harley","Quin", Gender.FEMALE)
    );

    private static List<Book> allBooks= List.of(
            new Book("SuperMan"),
            new Book("Batman"),
            new Book("Titans"),
            new Book("Suicide Squad")
    );


    private static List<Book> books = new ArrayList<>(allBooks);

    public static List<Person> getSampleListOfPeople(){
        return people;
    }

    public static List<Book> getAvailableBooks(){
        return books;
    }

    public static void removeFromAvailable(int index) {
        books.remove(index);
    }

    public static List<Book> getAllBooks(){
        return allBooks;
    }
}
