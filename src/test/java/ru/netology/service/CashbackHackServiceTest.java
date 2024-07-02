package ru.netology.service;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {

    @Test
    public void ifAmount0() { //не было покупок
        CashbackHackService service = new CashbackHackService();
        int amount = 0;
        int expected = 1000;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    public void ifAmountLessBoundary() { //последний до 1000
        CashbackHackService service = new CashbackHackService();
        int amount = 999;
        int expected = 1;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    public void ifAmountMoreBoundary() { //больше 1000
        CashbackHackService service = new CashbackHackService();
        int amount = 1001;
        int expected = 999;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    public void ifAmountEqualsBoundary() { //равное 1000
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;
        int expected = 0;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    public void ifAmount1() { //первый бонус
        CashbackHackService service = new CashbackHackService();
        int amount = 1;
        int expected = 999;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }

    @Test
    public void ifAmountAverageBoundary() { //среднее значение
        CashbackHackService service = new CashbackHackService();
        int amount = 500;
        int expected = 500;
        int actual = service.remain(amount);
        assertEquals(actual, expected);
    }
}