package org.tddtime.troco;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by rafaelperetta on 05/05/16.
 */
public class BillTest {

    @Test
    public void testExchangeWithOneBankNote() {
        Bill bill = new Bill(200.0);
        List<Double> bankNote = bill.pay(300.0);

        Assert.assertEquals(1, bankNote.size());
        Assert.assertTrue(bill.isPaid());
        Assert.assertEquals(new Double(100.0), bankNote.get(0));
    }

    @Test
    public void testExchangeWithTwoBankNotes() {
        Bill bill = new Bill(200.0);
        List<Double> bankNote = bill.pay(400.0);

        Assert.assertEquals(2, bankNote.size());
        Assert.assertEquals(new Double(100.0), bankNote.get(0));
        Assert.assertEquals(new Double(100.0), bankNote.get(1));
    }

    @Test
    public void testExchangeWithThreeBankNotes() {
        Bill bill = new Bill(200.0);
        List<Double> bankNote = bill.pay(500.0);

        Assert.assertEquals(3, bankNote.size());
        Assert.assertEquals(new Double(100.0), bankNote.get(0));
        Assert.assertEquals(new Double(100.0), bankNote.get(1));
    }

    @Test
    public void testExchangeWithFourBankNotes() {
        Bill bill = new Bill(200.0);
        List<Double> bankNote = bill.pay(450.0);

        Assert.assertEquals(3, bankNote.size());
        Assert.assertEquals(new Double(100.0), bankNote.get(0));
        Assert.assertEquals(new Double(100.0), bankNote.get(1));
        Assert.assertEquals(new Double(50.0), bankNote.get(2));
    }

    @Test
    public void testExchangeWithBankNotesAndCoins() {
        Bill bill = new Bill(200.0);
        List<Double> bankNote = bill.pay(487.67);

        bankNote.forEach(System.out::println);
        Assert.assertEquals(14, bankNote.size());
    }

    @Test
    public void testExchangeWithPaymentValueLessThanBillAmount() {
        try {
            Bill bill = new Bill(100.0);
            bill.pay(50.0);

            Assert.fail();
        } catch(IllegalArgumentException ex) {
            Assert.assertEquals(Bill.MSG_PAYMENT_VALUE_LESS_THAN_AMOUNT, ex.getMessage());
        }
    }

    @Test
    public void testExchangeWithNegativeBillAmount() {
        try {
            new Bill(-200.0);

            Assert.fail();
        } catch(IllegalArgumentException ex) {
            Assert.assertEquals(Bill.MSG_AMOUNT_LESS_THAN_ZERO, ex.getMessage());
        }

    }

    @Test
    public void testExchangeWithNegativePaymentValue() {
        try {
            Bill bill = new Bill(100.0);
            bill.pay(-50.0);

            Assert.fail();
        } catch(IllegalArgumentException ex) {
            Assert.assertEquals(Bill.MSG_NEGATIVE_PAYMENT_VALUE, ex.getMessage());
        }
    }
}