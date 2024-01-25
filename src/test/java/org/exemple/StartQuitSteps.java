package org.exemple;

import constans.Constans;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

public class StartQuitSteps {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(Constans.PAGE_URL);

        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookieButton();
    }

    @After
    public void down() {
        driver.quit();
    }

}
