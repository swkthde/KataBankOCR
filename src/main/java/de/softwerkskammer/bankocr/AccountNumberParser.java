package de.softwerkskammer.bankocr;

import java.util.Arrays;

public class AccountNumberParser {

    private static final int NUMBER_OF_DIGIT_COLS = 3;
    private static final int NUMBER_OF_DIGIT_ROWS = 3;
    private static final int NUMBER_OF_DIGITS = 9;

    protected static char parseDigit(char[][] digit) {

        if (Arrays.deepEquals(digit, Digits.ZERO)) {
            return '0';
        } else if (Arrays.deepEquals(digit, Digits.ONE)) {
            return '1';
        } else if (Arrays.deepEquals(digit, Digits.TWO)) {
            return '2';
        } else if (Arrays.deepEquals(digit, Digits.THREE)) {
            return '3';
        } else if (Arrays.deepEquals(digit, Digits.FOUR)) {
            return '4';
        } else if (Arrays.deepEquals(digit, Digits.FIVE)) {
            return '5';
        } else if (Arrays.deepEquals(digit, Digits.SIX)) {
            return '6';
        } else if (Arrays.deepEquals(digit, Digits.SEVEN)) {
            return '7';
        } else if (Arrays.deepEquals(digit, Digits.EIGHT)) {
            return '8';
        } else if (Arrays.deepEquals(digit, Digits.NINE)) {
            return '9';
        } else {
            throw new IllegalArgumentException("Cannot parse digit " + Arrays.deepToString(digit));
        }
    }

    public static String parseAccountNumber(char[][] accountNumber) {

        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    private static class Digits {

        final static char[][] ZERO = new char[][] {
                {' ','_',' '},
                {'|',' ','|'},
                {'|','_','|'}
        };

        final static char[][] ONE = new char[][] {
            {' ',' ',' '},
            {' ',' ','|'},
            {' ',' ','|'},
        };

        final static char[][] TWO = new char[][] {
            {' ','_',' '},
            {' ','_','|'},
            {' ','|','_'},
        };

        final static char[][] THREE = new char[][] {
            {' ','_',' '},
            {' ','_','|'},
            {' ','_','|'},
        };

        final static char[][] FOUR = new char[][] {
            {' ',' ',' '},
            {'|','_','|'},
            {' ',' ','|'},
        };

        final static char[][] FIVE = new char[][] {
            {' ','_',' '},
            {'|','_',' '},
            {' ','_','|'},
        };

        final static char[][] SIX = new char[][] {
            {' ','_',' '},
            {'|','_',' '},
            {'|','_','|'},
        };

        final static char[][] SEVEN = new char[][] {
            {' ','_',' '},
            {' ',' ','|'},
            {' ',' ','|'},
        };

        final static char[][] EIGHT = new char[][] {
            {' ','_',' '},
            {'|','_','|'},
            {'|','_','|'},
        };

        final static char[][] NINE = new char[][] {
            {' ','_',' '},
            {'|','_','|'},
            {' ','_','|'},
        };
    }
}
