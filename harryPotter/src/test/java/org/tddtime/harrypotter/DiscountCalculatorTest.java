package org.tddtime.harrypotter;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaelperetta on 26/05/16.
 */
public class DiscountCalculatorTest {

    @Before
    public void init() {

    }

    @Test
    public void testDiscountForOneBook() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter Book 1", 8.0));

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);

        assertEquals(0.0, discountCalculator.discount(), 0.0);
    }

    @Test
    public void testDiscountForTwoDifferentBooks() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter Book 1", 8.0));
        books.add(new Book("Harry Potter Book 2", 8.0));

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);

        assertEquals(0.8, discountCalculator.discount(), 0.0);
    }

    @Test
    public void testDiscountForTwoEqualBooks() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter Book 1", 8.0);
        books.add(book);
        books.add(book);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);

        assertEquals(0, discountCalculator.discount(), 0.0);
    }


    @Test
    public void testDiscountForThreeEqualBooks() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter Book 1", 8.0);
        Book book1 = new Book("Harry Potter Book 2", 8.0);
        Book book2 = new Book("Harry Potter Book 3", 8.0);

        books.add(book);
        books.add(book1);
        books.add(book2);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);

        assertEquals(2.4, discountCalculator.discount(), 0.01);
    }

    @Test
    public void testDiscountForFourEqualBooks() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter Book 1", 8.0);
        Book book1 = new Book("Harry Potter Book 2", 8.0);
        Book book2 = new Book("Harry Potter Book 3", 8.0);
        Book book3 = new Book("Harry Potter Book 4", 8.0);

        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);

        assertEquals(6.4, discountCalculator.discount(), 0.01);
    }

    @Test
    public void testDiscountForFiveEqualBooks() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter Book 1", 8.0);
        Book book1 = new Book("Harry Potter Book 2", 8.0);
        Book book2 = new Book("Harry Potter Book 3", 8.0);
        Book book3 = new Book("Harry Potter Book 4", 8.0);
        Book book4= new Book("Harry Potter Book 5", 8.0);

        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);


        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);

        assertEquals(10.0, discountCalculator.discount(), 0.01);
    }

    @Test
    public void testDiscountForTwoEqualBooksAndTwoDifferents() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter Book 1", 8.0);
        Book book1 = new Book("Harry Potter Book 1", 8.0);
        Book book2 = new Book("Harry Potter Book 2", 8.0);
        Book book3 = new Book("Harry Potter Book 2", 8.0);

        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);

        assertEquals(1.6, discountCalculator.discount(), 0.01);
    }

    @Test
    public void testKata() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter Book 1", 8.0);
        Book book2 = new Book("Harry Potter Book 2", 8.0);
        Book book3 = new Book("Harry Potter Book 3", 8.0);
        Book book4 = new Book("Harry Potter Book 4", 8.0);

        books.add(book);
        books.add(book);
        books.add(book2);
        books.add(book3);
        books.add(book3);
        books.add(book4);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);

        assertEquals((8 * 4 * 0.2) + (8 * 2 * 0.05), discountCalculator.discount(), 0.01);
    }

    @Test
    public void testKata2() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter Book 1", 8.0);
        Book book2 = new Book("Harry Potter Book 2", 8.0);
        Book book3 = new Book("Harry Potter Book 3", 8.0);
        Book book4 = new Book("Harry Potter Book 4", 8.0);
        Book book5 = new Book("Harry Potter Book 5", 8.0);

        books.add(book);
        books.add(book2);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);
        assertEquals(8 * 5 * 0.25, discountCalculator.discount(), 0.01);
    }

    @Test
    public void testKata3() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book("Harry Potter Book 1", 8.0);
        Book book2 = new Book("Harry Potter Book 2", 8.0);
        Book book3 = new Book("Harry Potter Book 3", 8.0);
        Book book4 = new Book("Harry Potter Book 4", 8.0);
        Book book5 = new Book("Harry Potter Book 5", 8.0);

        books.add(book);
        books.add(book);
        books.add(book2);
        books.add(book2);
        books.add(book3);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addBooks(books);
        assertEquals(2 * (8 * 4 * 0.2), discountCalculator.discount(), 0.01);
    }
}
