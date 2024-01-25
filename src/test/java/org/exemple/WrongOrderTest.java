package org.exemple;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.StatusOrderPage;
import pageobject.TopBar;

import java.time.Duration;

public class WrongOrderTest extends StartQuitSteps {

    @Test
    public void wrongOrderTest() {
        TopBar topBar = new TopBar(driver);
        StatusOrderPage statusOrderPage = new StatusOrderPage(driver);

        topBar.clickStatusOrder();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(statusOrderPage.getButtonGo()));
        statusOrderPage.inputNumberOrder("1");
        statusOrderPage.clickButtonGo();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(statusOrderPage.getButtonLook()));
        Assert.assertTrue("Картинка не отобразилась", statusOrderPage.setNotFound());
    }
}
