package de.softwerkskammer.bankocr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AccountNumberParserTest {

    @Test
    public void testParseAccountNumber() {

        // Each entry is 4 lines long
        // each line 27 characters
        // each account number 9 digits
    }

    @Test
    public void testParseDigit() {

        char[][] testDigit0 = new char[][] {
            {' ','_',' '},
            {'|',' ','|'},
            {'|','_','|'},
        };

        char[][] testDigit1 = new char[][] {
            {' ',' ',' '},
            {' ',' ','|'},
            {' ',' ','|'},
        };

        char[][] testDigit2 = new char[][] {
            {' ','_',' '},
            {' ','_','|'},
            {' ','|','_'},
        };

        char[][] testDigit3 = new char[][] {
            {' ','_',' '},
            {' ','_','|'},
            {' ','_','|'},
        };

        char[][] testDigit4 = new char[][] {
            {' ',' ',' '},
            {'|','_','|'},
            {' ',' ','|'},
        };

        char[][] testDigit5 = new char[][] {
            {' ','_',' '},
            {'|','_',' '},
            {' ','_','|'},
        };

        char[][] testDigit6 = new char[][] {
            {' ','_',' '},
            {'|','_',' '},
            {'|','_','|'},
        };

        char[][] testDigit7 = new char[][] {
            {' ','_',' '},
            {' ',' ','|'},
            {' ',' ','|'},
        };

        char[][] testDigit8 = new char[][] {
            {' ','_',' '},
            {'|','_','|'},
            {'|','_','|'},
        };

        char[][] testDigit9 = new char[][] {
            {' ','_',' '},
            {'|','_','|'},
            {' ','_','|'},
        };


        assertEquals("Cannot parse digit", '0', AccountNumberParser.parseDigit(testDigit0));
        assertEquals("Cannot parse digit", '1', AccountNumberParser.parseDigit(testDigit1));
        assertEquals("Cannot parse digit", '2', AccountNumberParser.parseDigit(testDigit2));
        assertEquals("Cannot parse digit", '3', AccountNumberParser.parseDigit(testDigit3));
        assertEquals("Cannot parse digit", '4', AccountNumberParser.parseDigit(testDigit4));
        assertEquals("Cannot parse digit", '5', AccountNumberParser.parseDigit(testDigit5));
        assertEquals("Cannot parse digit", '6', AccountNumberParser.parseDigit(testDigit6));
        assertEquals("Cannot parse digit", '7', AccountNumberParser.parseDigit(testDigit7));
        assertEquals("Cannot parse digit", '8', AccountNumberParser.parseDigit(testDigit8));
        assertEquals("Cannot parse digit", '9', AccountNumberParser.parseDigit(testDigit9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseDigit_failure() {

        char[][] testDigit = new char[][] {
            {' ','_',' '},
            {'|','?','|'},
            {'|','_','|'},
        };

        AccountNumberParser.parseDigit(testDigit);
    }
}
