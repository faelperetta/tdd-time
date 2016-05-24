package org.tddtime.expressionevaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by rafaelperetta on 23/05/16.
 */
public class ShuntingYard {


    public static final String EMPTY_SPACE = " ";

    private enum Operator {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);

        final int precedence;

        Operator(int p) {
            precedence = p;
        }
    }

    private static Map<String, Operator> ops = new HashMap<String, Operator>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
    }};

    private static boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }


    private static boolean isHigherPrecedence(String op1, String op2) {
        return ops.containsKey(op1) && ops.get(op1).precedence >= ops.get(op2).precedence;
    }

    public static String postFix(String infix) {

        StringBuilder output = new StringBuilder();
        Stack<String> stack = new Stack<String>();

        for (String token : infix.split(EMPTY_SPACE)) {

            if (isNumber(token)) {
                output.append(token).append(" ");
                continue;
            }

            if (ops.containsKey(token)) {
                while(!stack.isEmpty() && isHigherPrecedence(stack.peek(), token)) {
                    output.append(stack.pop()).append(EMPTY_SPACE);
                }
                stack.push(token);
                continue;
            }

            if ("(".equals(token)) {
                stack.push(token);
                continue;
            }

            if (")".equals(token)) {
                while (!stack.peek().equals("(")) {
                    output.append(stack.pop()).append(EMPTY_SPACE);
                }
                stack.pop();
                continue;
            }

        }

        while(!stack.isEmpty()) {
            output.append(stack.pop()).append(EMPTY_SPACE);
        }

        return output.toString().trim();

    }

    public static double evaluatePostFix(String postFixExpression) {
        Stack<String> stack = new Stack<String>();

        for (String token : postFixExpression.split(EMPTY_SPACE)) {

            if (isNumber(token)) {
                stack.push(token);
            }  else {

                double operand2 = Double.valueOf(stack.pop());
                double operand1 = Double.valueOf(stack.pop());

                switch (ops.get(token)) {
                    case ADD:
                        stack.push(String.valueOf(operand1 + operand2));
                        break;
                    case SUBTRACT:
                        stack.push(String.valueOf(operand1 - operand2));
                        break;
                    case MULTIPLY:
                        stack.push(String.valueOf(operand1 * operand2));
                        break;
                    case DIVIDE:
                        stack.push(String.valueOf(operand1 / operand2));
                        break;
                }

            }

        }

        return Double.valueOf(stack.pop());
    }

}
