package org.exemple;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;
import pageobject.OrderingScooterPage;

public class ButtonOrderMainTest extends StartQuitSteps {
    WebDriver driver;

    @Test
    public void buttonOrderMainTest() {
        MainPage main = new MainPage(driver);
        OrderingScooterPage orderingScooterPage = new OrderingScooterPage(driver);

        main.scroll();
        main.clickButtonOrderMain();
        Assert.assertTrue("Не отображается окно с полями ввода", orderingScooterPage.checkInputWindow());

    }
}
