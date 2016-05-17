package com.demo.bankorc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class AccountNumberParser {

    private static final int NUMBER_OF_DIGIT_COLS = 3;
    private static final int NUMBER_OF_DIGIT_ROWS = 3;
    private static final int NUMBER_OF_DIGITS = 9;

    public static List<String> getAccountNumbers(File sourceFile) throws IOException {
        
        List<String> accountNumbers = new LinkedList<>();
        String[] fileContents = readLines(sourceFile);
        
        for (int lineIndex = 0; lineIndex < fileContents.length; lineIndex += NUMBER_OF_DIGIT_ROWS + 1) {
            String[] accountEntry = Arrays.copyOfRange(fileContents, lineIndex, lineIndex + NUMBER_OF_DIGIT_ROWS);
            accountNumbers.add(parseEntry(accountEntry));
        }
        
        return accountNumbers;
    }
    
    private static String[] readLines(File file) throws IOException {
        
        ArrayList<String> lines = new ArrayList<>();
        
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {            
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        
        return lines.toArray(new String[]{});
    }

    private static String parseEntry(String[] accountEntry) {
        
        StringBuilder sb = new StringBuilder();
        
        for (int digitIndex = 0; digitIndex < NUMBER_OF_DIGITS; digitIndex++) {
            String[] digitRows = new String[NUMBER_OF_DIGIT_ROWS];

            int substringStartIndex = digitIndex * NUMBER_OF_DIGIT_COLS;
            for (int i = 0; i < NUMBER_OF_DIGIT_ROWS; i++) {
                digitRows[i] = accountEntry[i].substring(substringStartIndex, substringStartIndex + NUMBER_OF_DIGIT_COLS);
            }
            
            sb.append(parseDigit(digitRows));
        }

        return sb.toString();
    }

    private static String parseDigit(String[] digitRows) {

        if (Arrays.equals(digitRows, Digits.ZERO)) {
            return "0";
        } else if (Arrays.equals(digitRows, Digits.ONE)) {
            return "1";
        }  else if (Arrays.equals(digitRows, Digits.TWO)) {
            return "2";
        }  else if (Arrays.equals(digitRows, Digits.THREE)) {
            return "3";
        }  else if (Arrays.equals(digitRows, Digits.FOUR)) {
            return "4";
        }  else if (Arrays.equals(digitRows, Digits.FIVE)) {
            return "5";
        }  else if (Arrays.equals(digitRows, Digits.SIX)) {
            return "6";
        }  else if (Arrays.equals(digitRows, Digits.SEVEN)) {
            return "7";
        }  else if (Arrays.equals(digitRows, Digits.EIGHT)) {
            return "8";
        }  else if (Arrays.equals(digitRows, Digits.NINE)) {
            return "9";
        } else {
            throw new IllegalArgumentException("Cannot parse digit " + Arrays.toString(digitRows));
        }
    }
    
    private static class Digits {
        
        final static String[] ZERO = new String[] {
                " _ ",
                "| |",
                "|_|"
        };
        
        final static String[] ONE = new String[] {
                "   ",
                "  |",
                "  |"
        };
        
        final static String[] TWO = new String[] {
                " _ ",
                " _|",
                "|_ "
        };
        
        final static String[] THREE = new String[] {
                " _ ",
                " _|",
                " _|"
        };
        
        final static String[] FOUR = new String[] {
                "   ",
                "|_|",
                "  |"
        };
        
        final static String[] FIVE = new String[] {
                " _ ",
                "|_ ",
                " _|"
        };
        
        final static String[] SIX = new String[] {
                " _ ",
                "|_ ",
                "|_|"
        };
        
        final static String[] SEVEN = new String[] {
                " _ ",
                "  |",
                "  |"
        };
        
        final static String[] EIGHT = new String[] {
                " _ ",
                "|_|",
                "|_|"
        };
        
        final static String[] NINE = new String[] {
                " _ ",
                "|_|",
                " _|"
        };
    }
}
