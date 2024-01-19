package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void minBalanceFirst() {

        SavingAccount savingAccount = new SavingAccount(140_000, 15_000, 400_000, 2);
        Assertions.assertEquals(15_000, savingAccount.getMinBalance());

    }

    @Test
    public void minBalanceSecond() {
        SavingAccount savingAccount = new SavingAccount(10_000, 0, 400_000, 3);
        Assertions.assertEquals(0, savingAccount.getMinBalance());
    }

    @Test
    // Исключение вида IllegalArgumentException не выкидывается
    // при отрицательном значении minBalance
    public void minBalanceThird() {

        SavingAccount savingAccount = new SavingAccount(11_500, -1, 700_000, 4);
        Assertions.assertEquals(0, savingAccount.getMinBalance());
    }

    @Test
    // Исключение вида  IllegalArgumentException не выкидывается
    // при значении minBalance большем, чем значение maxBalance
    public void minBalanceFourth() {

        SavingAccount savingAccount = new SavingAccount(11_500, 800_000, 700_000, 4);
        Assertions.assertEquals(0, savingAccount.getMinBalance());
    }

    @Test
    public void maxBalanceFirst() {
        SavingAccount savingAccount = new SavingAccount(1_750, 0, 250_000, 7);
        Assertions.assertEquals(250_000, savingAccount.getMaxBalance());
    }

    @Test
    // Исключение вида IllegalArgumentException не выкидывается
    // при отрицательном значении maxBalance
    public void maxBalanceSecond() {

        SavingAccount savingAccount = new SavingAccount(3_500, 0, -1, 12);
        Assertions.assertEquals(0, savingAccount.getMaxBalance());
    }

    @Test

    public void maxBalanceThird() {
        SavingAccount savingAccount = new SavingAccount(3_000, 0, 90_000, 9);
        Assertions.assertEquals(90_000, savingAccount.getMaxBalance());
    }

    @Test
    // Исключение вида IllegalArgumentException не выкидывается
    // при значении maxBalance меньшем, чем значение minBalance
    public void maxBalanceFourth() {

        SavingAccount savingAccount = new SavingAccount(12_000, 10_000, 7_000, 12);
        Assertions.assertEquals(0, savingAccount.getMaxBalance());
    }

    @Test
    public void initialBalanceFirst() {
        SavingAccount savingAccount = new SavingAccount(5_000, 0, 147_000, 9);
        Assertions.assertEquals(5_000, savingAccount.getBalance());
    }


    @Test
    public void initialBalanceSecond() {
        SavingAccount savingAccount = new SavingAccount(0, 0, 147_000, 9);
        Assertions.assertEquals(0, savingAccount.getBalance());
    }

    @Test
    //  Исключение вида IllegalArgumentException не выкидывается
    //  при отрицательном значении initialBalance
    public void initialBalanceThird() {

        SavingAccount savingAccount = new SavingAccount(-1, 0, 150_000, 13);
        Assertions.assertEquals(0, savingAccount.getBalance());
    }

    @Test
    // Исключение вида IllegalArgumentException не выкидывается
    // при значении initialBalance большем, чем значение maxBalance
    public void initialBalanceFourth() {

        SavingAccount savingAccount = new SavingAccount(147_000, 1500, 100_000, 13);
        Assertions.assertEquals(0, savingAccount.getBalance());
    }

    @Test
    public void rateTestFirst() {
        SavingAccount savingAccount = new SavingAccount(0, 0, 0, 7);
        Assertions.assertEquals(7, savingAccount.getRate());
    }

    @Test
    public void rateTestSecond() {
        SavingAccount savingAccount = new SavingAccount(0, 0, 0, 0);
        Assertions.assertEquals(0, savingAccount.getRate());
    }


    @Test
    public void rateTestThird() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount savingAccount = new SavingAccount(10_000, 0, 250_000, -1);
        });
    }

    @Test
    public void payTestFirst() {
        SavingAccount savingAccount = new SavingAccount(5_000, 500, 500_000, 9);
        savingAccount.pay(750);
        Assertions.assertEquals(4_250, savingAccount.getBalance());
    }

    @Test
    public void payTestSecond() {
        SavingAccount savingAccount = new SavingAccount(5_000, 500, 500_000, 9);
        savingAccount.pay(0);
        Assertions.assertEquals(5_000, savingAccount.getBalance());
    }

    @Test
    public void payTestThird() {
        SavingAccount savingAccount = new SavingAccount(5_000, 500, 500_000, 9);
        savingAccount.pay(-1);
        Assertions.assertEquals(5_000, savingAccount.getBalance());
    }

    @Test
    public void payTestFourth() {
        // Отрицательный баланс при сумме покупки amount превышающей
        // остаток на  балансе
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 17);
        savingAccount.pay(37000);
        Assertions.assertEquals(27_000, savingAccount.getBalance());
    }

    @Test
    public void payTestFifth() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 16);
        Boolean expected = false;
        Boolean actual = savingAccount.pay(29_000);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payTestSixth() {
        // Отрицательный баланс при сумме покупки amount превышающей
        // установленный maxBalance
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.pay(3_700_000);
        Assertions.assertEquals(35_000, savingAccount.getBalance());
    }

    @Test
    public void payTestSeventh() {
        SavingAccount savingAccount = new SavingAccount(5_000, 500, 500_000, 9);
        Boolean expected = false;
        Boolean actual = savingAccount.pay(3_750_000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payTestEighth() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        Boolean expected = true;
        Boolean actual = savingAccount.pay(3450);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payTestNinth() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        Boolean expected = false;
        Boolean actual = savingAccount.pay(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void payTestTenth() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        Boolean expected = false;
        Boolean actual = savingAccount.pay(-100);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    // Переменная initialBalance  не учитывается
    // в итоговом балансе при пополнении счёта
    public void addTestFirst() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.add(253_640);
        Assertions.assertEquals(288_640, savingAccount.getBalance());
    }

    @Test
    public void addTestSecond() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.add(750_640);
        Assertions.assertEquals(35_000, savingAccount.getBalance());
    }

    @Test
    // Не отображается корректно итоговый баланс в пределах допустимого
    // максимального значения maxBalance при пополнении счёта
    public void addTestThird() {
        SavingAccount savingAccount = new SavingAccount(35_000, 500, 500_000, 16);
        savingAccount.add(465_000);
        Assertions.assertEquals(500_000, savingAccount.getBalance());


    }

    @Test
    public void addTestFourth() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        savingAccount.add(0);
        Assertions.assertEquals(27_000, savingAccount.getBalance());
    }

    @Test
    public void addTestFifth() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        savingAccount.add(-150);
        Assertions.assertEquals(27_000, savingAccount.getBalance());
    }

    @Test
    public void addTestSixth() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        Boolean expected = true;
        Boolean actual = savingAccount.add(7_500);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addTestSeventh() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        Boolean expected = false;
        Boolean actual = savingAccount.add(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addTestEighth() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        Boolean expected = false;
        Boolean actual = savingAccount.add(-350);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void yearChangeTestFirst() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 9);
        Assertions.assertEquals(2430, savingAccount.yearChange());
    }

    @Test
    public void yearChangeTestSecond() {
        SavingAccount savingAccount = new SavingAccount(27_000, 500, 500_000, 0);
        Assertions.assertEquals(0, savingAccount.yearChange());
    }


}
