package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusOrderPage {
    WebDriver driver;

    public StatusOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Введите номер заказа']")
    private WebElement inputNumberOrder;

    @FindBy(xpath = "//button[text()='Go!']")
    private WebElement buttonGo;

    @FindBy(xpath = "//img[@alt='Not found']")
    private WebElement notFound;

    @FindBy(xpath = "//button[text()='Посмотреть']")
    private WebElement buttonLook;


    public void inputNumberOrder(String n) {
        inputNumberOrder.sendKeys(n);
    }

    public void clickButtonGo() {
        buttonGo.click();
    }

    public WebElement getButtonGo() {
        return buttonGo;
    }

    public boolean setNotFound() {
        return notFound.isDisplayed();
    }

    public WebElement getButtonLook() {
        return buttonLook;
    }
}
