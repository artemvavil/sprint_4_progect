package org.exemple;

import constans.Constans;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.TopBar;
import pageobject.YandexPage;

import java.time.Duration;

public class LogoTest extends StartQuitSteps {

    @Test
    public void scooterLogoTest() {
        TopBar topBar = new TopBar(driver);

        topBar.clickScooterLogo();
        Assert.assertEquals(Constans.PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    public void yandexLogoTest(){
        TopBar topBar = new TopBar(driver);
        YandexPage yandexPage = new YandexPage(driver);

        topBar.clickYandexLogo();
        for(String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(yandexPage.getYandexSearch()));
        Assert.assertTrue(driver.getCurrentUrl().contains("dzen.ru"));
    }
}
