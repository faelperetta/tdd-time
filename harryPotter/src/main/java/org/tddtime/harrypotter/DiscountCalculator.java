package org.tddtime.harrypotter;

import java.util.*;

/**
 * Created by rafaelperetta on 26/05/16.
 */
public class DiscountCalculator {

    private List<Book> books;
    private double discount;
    private int booksSize = 0;

    private List<Set<Book>> booksGroup = new ArrayList<>();

    public void addBooks(List<Book> books) {
        this.books = new ArrayList<>();
        this.booksSize = books.size();
        books.forEach(book -> {
            if (!this.books.contains(book)) {
                this.books.add(book);
            }
        });

    }

    public double discount() {

        List<List<Book>> combinations = generateCombinations(new ArrayList<>(), books, new ArrayList<>());

        double maxDiscount = !combinations.isEmpty() ? calcDiscount(combinations.get(0)) : 0;
        maxDiscount = maxDiscount(combinations, maxDiscount);

        return maxDiscount;
    }

    private double maxDiscount(List<List<Book>> combinations, double maxDiscount) {
        int combinationsSize;
        for(int i = 0; i < combinations.size(); i++) {
            List<Book> currentCombination = combinations.get(i);
            combinationsSize = currentCombination.size();
            double discount = calcDiscount(currentCombination);

            for (int x = 0; x < combinations.size(); x++) {

                int size = combinationsSize + combinations.get(x).size();

                if (size <= booksSize) {
                    double disc = discount + calcDiscount(combinations.get(x));

                    if (disc > maxDiscount) {
                        maxDiscount = disc;
                    }
                }

            }
        }
        return maxDiscount;
    }

    private double calcDiscount(List<Book> books) {
        final double percentage;
        double discount = 0;

        if (books.size() == 2) {
            percentage = 0.05;
        }else if (books.size() == 3) {
            percentage = 0.1;
        } else if (books.size() == 4) {
            percentage = 0.2;
        } else if (books.size() == 5) {
            percentage = 0.25;
        } else {
            percentage = 0.0;
        }

        for(Book book : books) {
            discount += book.price() * percentage;
        }

        return discount;
    }

    protected List<List<Book>> generateCombinations(List<Book> activeGroup, List<Book> restOfBooks, List<List<Book>> combinations) {
        if (restOfBooks.isEmpty()) {
            if (activeGroup.size() > 1) {
                combinations.add(activeGroup);
            }
        } else {
            List<Book> newActiveGroup = new ArrayList<>(activeGroup);
            newActiveGroup.add(restOfBooks.get(0));

            List<Book> newRestOfBooks = new ArrayList<>(restOfBooks);
            newRestOfBooks.remove(0);

            generateCombinations(newActiveGroup, newRestOfBooks, combinations);
            generateCombinations(activeGroup, newRestOfBooks, combinations);
        }

        return combinations;
    }
}
