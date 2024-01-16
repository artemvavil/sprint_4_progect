package org.exemple;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.MainPage;

@RunWith(Parameterized.class)
public class QuestionsImportantTest extends StartQuitSteps {
    WebDriver driver;
    private final int questionNumbersAnInt;

    public QuestionsImportantTest(int questionNumbersAnInt) {
        this.questionNumbersAnInt = questionNumbersAnInt;
        PageFactory.initElements(driver, this);
    }

    @Parameterized.Parameters
    public static Object[][] questionNum() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},

        };
    }

    @Test
    public void questionsImportantTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.scroll();
        mainPage.clickArrow(questionNumbersAnInt);
        Assert.assertTrue(mainPage.checkTextArrow(questionNumbersAnInt));
    }
}
