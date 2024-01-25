package pageobject;

import constans.Constans;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "rcc-confirm-button")   //убираем табличку с куками
    private WebElement cookieButton;

    @FindBy(xpath = "//div[text()='Вопросы о важном']")   //заголовок "вопросы о важном"
    private WebElement questionsImportant;

    @FindBy(className = "accordion")  //Список с выплывающими текстами
    private List<WebElement> accordion;

    @FindBy(className = "Button_Button__ra12g Button_Middle__1CSJM")
    private WebElement buttonOrderMain;

    public void closeCookieButton() {
        cookieButton.click();
    }

    //метод для пролистывания страницы
    public void scroll() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionsImportant);
    }

    //метод который нажимает на стрелочки
    public void clickArrow(int a) {
        By arrow = By.id("accordion__heading-" + a);
        driver.findElement(arrow).click();
    }

    //мотод поверки текста после нажатия на стрелку
    public boolean checkTextArrow(int n) {
        By element = By.xpath("//div[contains(@id, 'accordion__panel-" + n + "')]//p");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        String actualText = driver.findElement(element).getText();
        return actualText.equals(Constans.EXPECTED_TEXT[n]);
    }

    public void clickButtonOrderMain() {
        buttonOrderMain.click();
    }
}
