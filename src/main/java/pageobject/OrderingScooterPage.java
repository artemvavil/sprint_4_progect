package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderingScooterPage {
    WebDriver driver;

    public OrderingScooterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Локаторы

    @FindBy(className = "Order_Content__bmtHS")
    private WebElement inputWindow;

    @FindBy(xpath = ".//input[@placeholder='* Имя']")
    private WebElement name;

    @FindBy(xpath = ".//input[@placeholder='* Фамилия']")
    private WebElement secondName;

    @FindBy(xpath = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement address;

    @FindBy(xpath = ".//input[@placeholder='* Станция метро']")
    private WebElement metroStation;

    @FindBy(xpath = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//button[text()='Далее']")
    private WebElement buttonNext;

    //локаторы на корректность вводимых данных
    @FindBy(xpath = "//div[text()='Введите корректное имя']")
    private WebElement correctName;

    @FindBy(xpath = "//div[text()='Введите корректную фамилию']")
    private WebElement correctSecondName;

    @FindBy(xpath = "//div[text()='Введите корректный адрес']")
    private WebElement correctAddress;

    @FindBy(xpath = "//div[text()='Выберите станцию']")
    private WebElement chooseStation;
    @FindBy(xpath = "//div[text()='Введите корректный номер']")
    private WebElement correctPhoneNumber;

    //локаторы "про аренду"
    @FindBy(xpath = ".//input[@placeholder='* Когда привезти самокат']")
    private WebElement dateRent;

    @FindBy(className = "Dropdown-control")
    private WebElement rentalPeriod;

    @FindBy(className = "Order_Checkboxes__3lWSI")
    private List<WebElement> colorScooter;

    @FindBy(className = "Input_InputContainer__3NykH")
    private WebElement comment;

    @FindBy(className = "App_App__15LM-")
    private WebElement root;

    @FindBy(xpath = "//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']")
    private WebElement buttonOrderDown;

    @FindBy(xpath = "//div[@class='Order_Buttons__1xGrp']//button[text()='Назад']")
    private WebElement buttonBack;

    //локаторы окна подтверждения

    @FindBy(xpath = "//button[text()='Нет']")
    private WebElement buttonNo;

    @FindBy(xpath = "//button[text()='Да']")
    private WebElement buttonYes;

    @FindBy(className = "Order_ModalHeader__3FDaJ")
    private WebElement checkResult;


    //Методы

    public boolean checkInputWindow(){
        return  inputWindow.isDisplayed();
    }
    public void inputName(String text) {
        name.sendKeys(text);
    }

    public void inputSecondName(String text) {
        secondName.sendKeys(text);
    }

    public void inputAddress(String text) {
        address.sendKeys(text);
    }

    public void checkMetroStation(int n) {
        metroStation.click();
        driver.findElement(By.xpath(".//li[@class='select-search__row' and @data-index='" + n + "']")).click();
    }

    public void inputPhoneNumber(String text) {
        phoneNumber.sendKeys(text);
    }


    //методы "про аренду"
    public void chooseDateRent(String date) {
        this.dateRent.sendKeys(date);
        root.click();
    }

    public void chooseRentalPeriod(int n) {
        if (n > 0 && n <= 7) {
            rentalPeriod.click();
            driver.findElement(By.xpath("//div[@class='Dropdown-option'][" + n + "]")).click();
        }
    }

    public void chooseColorScooter(int i) {
        if (i > 0 && i <= 2) {
            colorScooter.get(i).click();
        }
    }

    public void inputComment(String text) {
        comment.sendKeys(text);
    }

    public void setButtonOrderDown() {
        buttonOrderDown.click();
    }

    public void setButtonNext() {
        buttonNext.click();
    }

    public boolean isCheckResult(String expectedResult) {
        return checkResult.getText().contains(expectedResult);
    }

    //Методы окна подтверждения
    public void setButtonNo() {
        buttonNo.click();
    }

    public void setButtonYes() {
        buttonYes.click();
    }


    //методы о введении корректных данных
    public boolean checkCorrectName(){
        return correctName.isDisplayed();
    }
    public boolean checkCorrectSecondName(){
        return correctSecondName.isDisplayed();
    }
    public boolean checkCorrectAddress(){
        return correctAddress.isDisplayed();
    }

    public boolean checkCorrectStation(){
        return chooseStation.isDisplayed();
    }
    public boolean checkPhoneNumber(){
        return correctPhoneNumber.isDisplayed();
    }

}
