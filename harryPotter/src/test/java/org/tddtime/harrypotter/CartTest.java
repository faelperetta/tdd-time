package org.tddtime.harrypotter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafaelperetta on 26/05/16.
 */
public class CartTest {

    private List<Book> books = new ArrayList<Book>();
    private Cart cart;

    @Before
    public void init() {
        cart = new Cart();

        books.add(new Book("Harry Potter Book 1", 8.0));
        books.add(new Book("Harry Potter Book 2", 8.0));
    }

    @Test
    public void testAddOneItemToCart() {
        cart.addBook(this.books.get(0));
        List<Book> cartBooks = cart.getBooks();

        assertEquals(1, cart.size());
        assertEquals(books.get(0).title(), cartBooks.get(0).title());
        assertEquals(8.0, cartBooks.get(0).price(), 0);
    }

    @Test
    public void testCartTotalValue() {

        cart.addBook(books.get(0));
        cart.addBook(books.get(1));

        assertEquals(2, cart.size());
        assertEquals(16.0, cart.total(), 0);
    }

    @Test
    public void testRemoveBookFromCart() {
        cart.addBook(books.get(0));
        cart.addBook(books.get(1));

        assertEquals(2, cart.size());
        assertEquals(16.0, cart.total(), 0);

        cart.removeBook(books.get(0));
        assertEquals(1, cart.size());
        assertEquals(8.0, cart.total(), 0);
    }

}
