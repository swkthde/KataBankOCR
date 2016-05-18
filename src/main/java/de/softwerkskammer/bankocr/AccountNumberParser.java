package de.softwerkskammer.bankocr;

import java.util.Arrays;

public class AccountNumberParser {

    protected static char parseDigit(char[][] digit) {

        if (Arrays.deepEquals(digit, Digits.ZERO)) {
            return '0';
        } else {
            throw new IllegalArgumentException("Cannot parse digit " + Arrays.deepToString(digit));
        }
    }

    private static class Digits {

        final static char[][] ZERO = new char[][] {
                {' ','_',' '},
                {'|',' ','|'},
                {'|','_','|'}
        };
    }
}
