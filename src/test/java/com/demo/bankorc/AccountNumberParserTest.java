package com.demo.bankorc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import com.demo.bankorc.AccountNumberParser;


public class AccountNumberParserTest {

    @Test
    public void testParseFile_SingleAccount() throws IOException {

        File testFile = getTestFile("account-123456789.txt");
        List<String> accountNumbers = AccountNumberParser.getAccountNumbers(testFile);
        assertEquals("Could not parse account number", "123456789", accountNumbers.get(0));
        
        testFile = getTestFile("account-490067715.txt");
        accountNumbers = AccountNumberParser.getAccountNumbers(testFile);
        assertEquals("Could not parse account number", "490067715", accountNumbers.get(0));
    }

    @Test
    public void testParseFile_MultipleAccounts() throws IOException {

        File testFile = getTestFile("multiple-accounts.txt");
        List<String> accountNumbers = AccountNumberParser.getAccountNumbers(testFile);
        for (int i = 0; i <= 9; i++) {
            assertEquals("Could not parse account number",
                    new String(new char[9]).replace("\0", Integer.toString(i)),
                    accountNumbers.get(i));
        }
        assertEquals("Could not parse all account numbers", 10, accountNumbers.size());              
    }
    
    
    private File getTestFile(String fileName) {
        
        URL testFileUrl = ClassLoader.getSystemResource(fileName);
        return new File(testFileUrl.getPath());
    }
}
