package org.tddtime.expressionevaluator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by rafaelperetta on 23/05/16.
 */

public class ShuntingYardTest {

    @Test
    public void testPostFixSimpleAddOperation() {
        String postfix = ShuntingYard.postFix("1 + 2");
        Assert.assertEquals("1 2 +", postfix);
    }

    @Test
    public void testPostFixExpressionWithPrecedence() {
        String postfix = ShuntingYard.postFix("3 * 2 + 5");
        Assert.assertEquals("3 2 * 5 +", postfix);
    }

    @Test
    public void testPostFixExpressionWithParentheses() {
        String postfix = ShuntingYard.postFix("3 * ( 2 + 5 )");
        Assert.assertEquals("3 2 5 + *", postfix);
    }

    @Test
    public void testPostFixComplexExpressionWithParentheses() {
        String postfix = ShuntingYard.postFix("1 - 3 * ( ( 2 + 5 ) / 5 )");
        Assert.assertEquals("1 3 2 5 + 5 / * -", postfix);
    }

    @Test
    public void testSimplePostFixEvaluate() {
        Assert.assertEquals(3d, ShuntingYard.evaluatePostFix("1 2 +"), 0);
    }

    @Test
    public void testSimplePostFixWithPrecedenceEvaluate() {
        Assert.assertEquals(11d, ShuntingYard.evaluatePostFix("1 2 5 * +"), 0);
    }
}
