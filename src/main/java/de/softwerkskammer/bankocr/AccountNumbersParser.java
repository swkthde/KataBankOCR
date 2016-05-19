package de.softwerkskammer.bankocr;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AccountNumbersParser {

    private static final int NUMBER_OF_DIGIT_COLS = 3;
    private static final int NUMBER_OF_DIGIT_ROWS = 3;
    private static final int NUMBER_OF_DIGITS = 9;

    public static List<String> getAccountNumbers(File accountNumbersFile) throws IOException {

        List<String> accountNumbers = new ArrayList<>();
        List<String> content = Files.readAllLines(accountNumbersFile.toPath());

        for (int lineIndex = 0; lineIndex < content.size(); lineIndex += NUMBER_OF_DIGIT_ROWS + 1) {
            char[][] accountEntry = new char[NUMBER_OF_DIGIT_ROWS][NUMBER_OF_DIGIT_COLS];
            for (int rowIndex = 0; rowIndex < NUMBER_OF_DIGIT_ROWS; rowIndex++)
                accountEntry[rowIndex] = content.get(rowIndex).toCharArray();
            accountNumbers.add(parseAccountNumber(accountEntry));
        }

        return accountNumbers;
    }

    protected static String parseAccountNumber(char[][] accountNumber) {

        StringBuilder sb = new StringBuilder();

        for (int digitIndex = 0; digitIndex < NUMBER_OF_DIGITS; digitIndex++) {
            char[][] digit = new char[NUMBER_OF_DIGIT_ROWS][NUMBER_OF_DIGIT_COLS];

            int digitStartIndex = digitIndex * NUMBER_OF_DIGIT_COLS;
            int digitEndIndex = digitStartIndex + NUMBER_OF_DIGIT_COLS;

            for (int rowIndex = 0; rowIndex < NUMBER_OF_DIGIT_ROWS; rowIndex++) {
                digit[rowIndex] = Arrays.copyOfRange(accountNumber[rowIndex], digitStartIndex, digitEndIndex);
            }

            sb.append(parseDigit(digit));
        }

        return sb.toString();
    }

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
}


class Digits {

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
        {'|','_',' '},
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