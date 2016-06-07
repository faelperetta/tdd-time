package org.tddtime.harrypotter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaelperetta on 26/05/16.
 */
public class Cart {

    private List<Book> books;
    private double total;

    public Cart() {
        books = new ArrayList<Book>();
    }


    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        total += book.price();
    }

    public void removeBook(Book book) {
        books.remove(book);
        total -= book.price();
    }

    public int size() {
        return books.size();
    }

    public double total() {
        return total;
    }

}