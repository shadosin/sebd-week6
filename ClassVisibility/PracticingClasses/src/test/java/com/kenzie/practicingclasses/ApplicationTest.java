package com.kenzie.practicingclasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import software.amazon.ion.Timestamp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    // Set up streams to test console input and output
    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    public void setTestInput() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void createAccountWithName_Test() {
        String accountUserName = getRandomUserName(6);
        Account account = new Account(accountUserName);
        int balance = 0;
        String firstThreeCharactersInAccountID = accountUserName.substring(0, 3);
        String accountId = account.getAccountId();
        boolean accountIdStartsWith = accountId.startsWith(firstThreeCharactersInAccountID);

        assertEquals(accountUserName, account.getUserName(), "userName is not set correctly") ;
        assertEquals(9, account.getAccountId().length(), "accountId is 9 characters long") ;
        assertEquals(true, accountIdStartsWith, "accountId starts with " + firstThreeCharactersInAccountID) ;
        assertEquals(0, account.getBalance(), "balance starts at " + balance) ;
    }

    @Test
    public void createAccountWithNameAndAccountId_Test() {
        Random rnd = new Random();
        String accountUserName = getRandomUserName(6);
        String firstThreeCharactersInAccountID = accountUserName.substring(0, 3);
        String accountId = firstThreeCharactersInAccountID + String.format("%06d", rnd.nextInt(6));
        int balance = 0;


        Account account = new Account(accountUserName, accountId);
        assertEquals(accountUserName, account.getUserName(), "userName is set correctly") ;
        assertEquals(accountId, account.getAccountId(), "accountId is set correctly") ;
        assertEquals(balance, account.getBalance(), "balance starts at 0") ;
    }

    @Test
    public void createAccountWithNameAccountIdAndBalance_Test() {
        Random rnd = new Random();
        String accountUserName = getRandomUserName(6);
        String firstThreeCharactersInAccountID = accountUserName.substring(0, 3);
        String accountId = firstThreeCharactersInAccountID + String.format("%06d", rnd.nextInt(6));
        double balance = rnd.nextDouble();

        Account account = new Account(accountUserName, accountId, balance);
        assertEquals(accountUserName, account.getUserName(), "userName is set correctly") ;
        assertEquals(accountId, account.getAccountId(), "accountId is set correctly") ;
        assertEquals(balance, account.getBalance(), "balance is set correctly") ;
    }

    @Test
    public void canMakeDeposit_Test() {
        Random rnd = new Random();
        String accountUserName = getRandomUserName(6);
        String firstThreeCharactersInAccountID = accountUserName.substring(0, 3);
        String accountId = firstThreeCharactersInAccountID + String.format("%06d", rnd.nextInt(6));
        double balance = 0;

        double deposit1 = rnd.nextDouble();
        double deposit2 = rnd.nextDouble();
        double sumOfDeposits = deposit1 + deposit2;

        Account account = new Account(accountUserName);
        assertEquals(balance, account.getBalance(), "balance starts at 0") ;
        account.makeDeposit(deposit1);
        assertEquals(deposit1, account.getBalance(), "balance updates") ;
        account.makeDeposit(deposit2);
        assertEquals(sumOfDeposits, account.getBalance(), "balance updates second time") ;
    }

    @Test
    public void canMakeSuccessfulWithdrawal_Test() {
        Random rnd = new Random();
        String accountUserName = getRandomUserName(6);
        String firstThreeCharactersInAccountID = accountUserName.substring(0, 3);
        String accountId = firstThreeCharactersInAccountID + String.format("%06d", rnd.nextInt(6));
        double startingBalance = 5000;
        Account account = new Account(accountUserName, accountId, startingBalance);

        double withdrawal1 =  getRandomDoubleInRange(0.00, 2000.00);
        double amountLeftAfterWithdraw1 = account.getBalance() - withdrawal1;
        double withdrawal2 =  getRandomDoubleInRange(0.00, 1000.00);
        double amountLeftAfterWithdraw2 = amountLeftAfterWithdraw1 - withdrawal2;


        assertEquals(startingBalance, account.getBalance(), "balance initializes") ;
        double returnAmount = account.makeWithdrawal(withdrawal1);
        assertEquals(withdrawal1, returnAmount, "Correct amount is returned");
        assertEquals(amountLeftAfterWithdraw1, account.getBalance(), "balance updates") ;
        returnAmount = account.makeWithdrawal(withdrawal2);
        assertEquals(withdrawal2, returnAmount, "Correct amount is returned second time");
        assertEquals(amountLeftAfterWithdraw2, account.getBalance(), "balance updates second time") ;
    }

    @Test
    public void canMakeFailingWithdrawal_Test() {
        Random rnd = new Random();
        String accountUserName = getRandomUserName(6);
        String firstThreeCharactersInAccountID = accountUserName.substring(0, 3);
        String accountId = firstThreeCharactersInAccountID + String.format("%06d", rnd.nextInt(6));
        double startingBalance = 5000;
        Account account = new Account(accountUserName, accountId, startingBalance);

        double invalidWithdrawal =  getRandomDoubleInRange(6000.00, 20000.00);

        assertEquals(startingBalance, account.getBalance(), "balance initializes") ;
        double returnAmount = account.makeWithdrawal(invalidWithdrawal);
        assertEquals(0, returnAmount, "0 is returned");
        assertEquals(startingBalance, account.getBalance(), "balance does not change updates") ;
    }

    @Test
    public void canMakeSuccessfulTransfer_Test() {

        Random rnd = new Random();
        String accountUserName1 = getRandomUserName(6);
        String firstThreeCharactersInAccountID1 = accountUserName1.substring(0, 3);
        String accountId1 = firstThreeCharactersInAccountID1 + String.format("%06d", rnd.nextInt(6));
        double startingBalanceAccount1 = 5000;

        Account account1 = new Account(accountUserName1, accountId1, startingBalanceAccount1);

        String accountUserName2 = getRandomUserName(6);
        String firstThreeCharactersInAccountID2 = accountUserName2.substring(0, 3);
        String accountId2 = firstThreeCharactersInAccountID2 + String.format("%06d", rnd.nextInt(6));
        double startingBalanceAccount2 = 0;

        Account account2 = new Account(accountUserName2, accountId2, startingBalanceAccount2);

        double randomTransferAmount =  getRandomDoubleInRange(3000.00, 4000.00);

        assertEquals(startingBalanceAccount1, account1.getBalance(), "account1 balance starts at 5000");
        assertEquals(startingBalanceAccount2, account2.getBalance(), "account2 balance starts at 0");
        Application.transferBetween(account1, account2, randomTransferAmount);
        assertEquals(startingBalanceAccount1 - randomTransferAmount, account1.getBalance(), "account1 balance updates");
        assertEquals(startingBalanceAccount2 + randomTransferAmount, account2.getBalance(), "account2 balance updates");

        //assertEquals("Payment completed. Transferred 3000.0 from tes123456 to tes654321\n", outContent.toString(), "Correct message is printed");
        //Modify unit test to do string contains check
        assertEquals(true, outContent.toString().indexOf("Payment completed. Transferred " + randomTransferAmount + " from " + accountId1 + " to " + accountId2) > -1,"Expected: 'Payment completed. Transferred " + randomTransferAmount + " from " + accountId1 + " to " + accountId2 + "'. Actual: " + outContent.toString() + "\nCheck for exact match including spaces.");
    }

    @Test
    public void canMakeFailedTransfer_Test() {

        Random rnd = new Random();
        String accountUserName1 = getRandomUserName(6);
        String firstThreeCharactersInAccountID1 = accountUserName1.substring(0, 3);
        String accountId1 = firstThreeCharactersInAccountID1 + String.format("%06d", rnd.nextInt(6));
        double startingBalanceAccount1 = 5000;

        Account account1 = new Account(accountUserName1, accountId1, startingBalanceAccount1);

        String accountUserName2 = getRandomUserName(6);
        String firstThreeCharactersInAccountID2 = accountUserName2.substring(0, 3);
        String accountId2 = firstThreeCharactersInAccountID2 + String.format("%06d", rnd.nextInt(6));
        double startingBalanceAccount2 = 0;

        Account account2 = new Account(accountUserName2, accountId2, startingBalanceAccount2);


        double randomTransferAmount =  getRandomDoubleInRange(startingBalanceAccount1 + 1, 2000000.00);

        assertEquals(startingBalanceAccount1, account1.getBalance(), "account1 balance starts at 5000");
        assertEquals(startingBalanceAccount2, account2.getBalance(), "account2 balance starts at 0");
        Application.transferBetween(account1, account2, randomTransferAmount);
        assertEquals(startingBalanceAccount1, account1.getBalance(), "account1 balance does not update");
        assertEquals(startingBalanceAccount2, account2.getBalance(), "account2 balance does not update");

        //assertEquals("Payment failed. Insufficient Funds.\n", outContent.toString(), "Correct message is printed");
        //Modify unit test to do string contains check
        assertEquals(true, outContent.toString().indexOf("Payment failed. Insufficient Funds.") > -1,"Expected:'Payment failed. Insufficient Funds.' Actual: " + outContent.toString() + "\nCheck for exact match including spaces.");
    }


    @Test
    public void runMain() {
        boolean crashed = false;
        try {
            Application.main(new String[]{});
        } catch (Exception e) {
            crashed = true;
        }

        assertEquals(false, crashed, "App can run without crashing") ;
    }

    private String getRandomUserName(int lengthOfUsername) {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() < lengthOfUsername) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            stringBuilder.append(CHARS.charAt(index));
        }

       return stringBuilder.toString().toLowerCase();
    }

    private double getRandomDoubleInRange(double rangeMin, double rangeMax) {
        Random r = new Random();
        double randomInRangeDouble = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        DecimalFormat df = new DecimalFormat("0.00");
        double roundedValue = Double.parseDouble(df.format(randomInRangeDouble));
        return roundedValue;
    }

}