package org.tddtime.troco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rafaelperetta on 05/05/16.
 */
public class Bill {

    private static final List<Double> NOTES = Arrays.asList(100.0, 50.0, 10.0, 5.0, 1.0, 0.50, 0.10, 0.05, 0.01);

    protected static final String MSG_AMOUNT_LESS_THAN_ZERO = "You cannot create a negative bill.";
    protected static final String MSG_NEGATIVE_PAYMENT_VALUE = "Negative values are not able to pay the bill.";
    protected static final String MSG_PAYMENT_VALUE_LESS_THAN_AMOUNT = "The amount is greater than payment value.";

    private double amount;

    public Bill(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(MSG_AMOUNT_LESS_THAN_ZERO);
        }
        this.amount = amount;
    }

    public List<Double> pay(double paymentValue) {

        checkPaymentValue(paymentValue);

        List<Double> bankNotes = new ArrayList<>();

        double change = paymentValue - amount;
        amount = 0.0;

        Iterator<Double> bankNotesIterator = NOTES.iterator();
        Double note = bankNotesIterator.next();

        while(change > 0) {

            if (change >= note) {
                change -= note;
                bankNotes.add(note);
                continue;
            }

            if (bankNotesIterator.hasNext()) {
                note = bankNotesIterator.next();
                continue;
            }
            change = 0;

        }

        return bankNotes;

    }

    /**
     * Verify if the payment value is valid, otherwise throw an {@link IllegalArgumentException}
     * @param paymentValue
     */
    protected void checkPaymentValue(double paymentValue) {
        if (paymentValue < 0) {
            throw new IllegalArgumentException(MSG_NEGATIVE_PAYMENT_VALUE);
        }

        if (paymentValue < amount) {
            throw new IllegalArgumentException(MSG_PAYMENT_VALUE_LESS_THAN_AMOUNT);
        }
    }

    public boolean isPaid() {
        return this.amount == 0;
    }
}