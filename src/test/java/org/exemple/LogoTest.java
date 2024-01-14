package org.exemple;

import constans.Constans;
import org.junit.Assert;
import org.junit.Test;
import page_object.MainPage;
import page_object.TopBar;

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

        topBar.clickYandexLogo();
        for(String tab : driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
    }
}
