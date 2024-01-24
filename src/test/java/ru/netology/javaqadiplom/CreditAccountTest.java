package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    //Баланс (balance) приравнивается к сумме пополнения (amount)
    // в методе add
    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(8_000, account.getBalance());
    }

    @Test
    public void IllegalRateExceptionTest () {

        Assertions.assertThrows(IllegalArgumentException.class,
                () ->  new CreditAccount(0, 5_000, -5) );

    }
    //Исключение IllegalArgumentException
    // не выкидывается при отрицательном значении initialBalance
    @Test
    public void IllegalInitialBalanceExceptionTest () {

        Assertions.assertThrows(IllegalArgumentException.class,
            () ->  new CreditAccount(-1_000, 5_000, 15) );

    }

    //Исключение IllegalArgumentException
    // не выкидывается при отрицательном значении creditLimit
    @Test
    public void IllegalCreditLimitExceptionTest () {

        Assertions.assertThrows(IllegalArgumentException.class,
                () ->  new CreditAccount(1_000, -5_000, 15) );

    }

    // Баланс (balance) приравниется к сумме оплаты (amount)
    // при initialBalance больше creditLimit в методе pay
    @Test
    public void payBalanceHigherThanCreditLimitTest() {
        CreditAccount account = new CreditAccount(
                4_000,
                5_000,
                15
        );

        account.pay(4_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    // Баланс (balance) изменяется
    // при initialBalance меньше creditLimit в методе pay
    @Test
    public void payBalanceLessThanCreditLimitTest() {
        CreditAccount account = new CreditAccount(
                5_000,
                4_000,
                15
        );

        account.pay(10_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void payBalanceEqualCreditLimitTest() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                15
        );

        account.pay(10_000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }


    @Test
    public void payAmountLessThanZeroTest() {
        CreditAccount account = new CreditAccount(
                5_000,
                4_000,
                15
        );

        account.pay(-10_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void addAmountLessThanZeroTest() {
        CreditAccount account = new CreditAccount(
                5_000,
                4_000,
                15
        );

        account.add(-10_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void SumPercentAtBalanceLessThanZeroTest() {
        CreditAccount account = new CreditAccount(
                200,
                4_000,
                15
        );
        account.balance = -200;
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void SumPercentAtBalanceZeroTest() {
        CreditAccount account = new CreditAccount(
                0,
                4_000,
                15
        );
        account.balance = 0;
        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void SumPercentAtBalanceHigherThanZeroTest() {
        CreditAccount account = new CreditAccount(
                200,
                4_000,
                15
        );
        account.balance = 200;
        Assertions.assertEquals(0, account.yearChange());
    }

}
