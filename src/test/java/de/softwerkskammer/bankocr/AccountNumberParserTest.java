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

        char[][] testDigit = new char[][] {
            {' ','_',' '},
            {'|',' ','|'},
            {'|','_','|'},
        };

        char digit = AccountNumberParser.parseDigit(testDigit);
        assertEquals("Cannot parse digit", '0', digit);
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
