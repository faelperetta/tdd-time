package org.tddtime.harrypotter;

/**
 * Created by rafaelperetta on 26/05/16.
 */
public class Book {

    private String title;
    private double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String title() {
        return title;
    }

    public double price() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book) obj;
        return this.title.equals(book.title());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
