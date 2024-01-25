package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexPage {
    WebDriver driver;
    public YandexPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='navigation-tab__tabContentInline-3d']")
    private WebElement yandexSearch;

    public WebElement getYandexSearch(){
        return  yandexSearch;
    }
}
