package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopBar {
    WebDriver driver;

    public TopBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Объекты
    @FindBy(className = "Header_LogoYandex__3TSOI")
    private WebElement yandexLogo;

    @FindBy(className = "Header_LogoScooter__3lsAR")
    private WebElement scooterLogo;

    @FindBy(className = "Button_Button__ra12g")
    public WebElement buttonOrdering;

    @FindBy(className = "Header_Link__1TAG7")
    private WebElement statusOrder;


    //методы клика по кнопкам в шапке"
    public void clickButtonOrdering() {
        buttonOrdering.click();
    }

    public void clickYandexLogo() {
        yandexLogo.click();
    }

    public void clickScooterLogo() {
        scooterLogo.click();
    }

    public void clickStatusOrder() {
        statusOrder.click();
    }

}
