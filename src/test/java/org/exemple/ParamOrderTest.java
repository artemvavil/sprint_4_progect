package org.exemple;

import com.sun.tools.javac.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.OrderingScooterPage;
import pageobject.TopBar;

@RunWith(Parameterized.class)
public class ParamOrderTest extends StartQuitSteps {

    private final String name;
    private final String secondName;
    private final String address;
    private final int metroStation;
    private final String phoneNumber;


    public ParamOrderTest(String name, String secondName, String address, int metroStation, String phoneNumber) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] users() {
        return new Object[][]{
                {"Иван", "Иванов", "Ленина", 2, "89109109109"},
                {"Петр", "Петров", "Победы", 6, "89209209209"}
        };
    }

    @Test
    public void orderTest() {
        TopBar topBar = new TopBar(driver);
        OrderingScooterPage orderingScooterPage = new OrderingScooterPage(driver);

        topBar.clickButtonOrdering(); //нажать на верхнюю кнопку заказать

        //первое окно ввода
        orderingScooterPage.inputName(name);
        orderingScooterPage.inputSecondName(secondName);
        orderingScooterPage.inputAddress(address);
        orderingScooterPage.checkMetroStation(metroStation);
        orderingScooterPage.inputPhoneNumber(phoneNumber);
        orderingScooterPage.setButtonNext();

        //второе окно ввода
        orderingScooterPage.chooseDateRent("01.01.2024");
        orderingScooterPage.chooseRentalPeriod(5);
        orderingScooterPage.chooseColorScooter(2);
        orderingScooterPage.inputComment("Hi");
        orderingScooterPage.setButtonOrderDown();

        //окно подтверждения
        orderingScooterPage.setButtonYes();
        boolean result = orderingScooterPage.isCheckResult("Заказ оформлен");
        Assert.assertTrue("Заказ не оформлен", result);
    }
}
