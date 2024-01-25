package org.exemple;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.OrderingScooterPage;
import pageobject.TopBar;

public class OrderErrorTests extends StartQuitSteps {

    @Before
    public void baseStep(){
        OrderingScooterPage orderingScooterPage = new OrderingScooterPage(driver);
        TopBar topBar = new TopBar(driver);

        topBar.clickButtonOrdering();
        orderingScooterPage.setButtonNext();
    }

    @Test
    public void corrName() {
        OrderingScooterPage orderingScooterPage = new OrderingScooterPage(driver);
        Assert.assertTrue("Не отображается ошибка Имени", orderingScooterPage.checkCorrectName());
    }

    @Test
    public void corrSecondName() {
        OrderingScooterPage orderingScooterPage = new OrderingScooterPage(driver);
        Assert.assertTrue("Не отображается ошибка Фамилии", orderingScooterPage.checkCorrectSecondName());
    }

    @Test
    public void corrAddress() {
        OrderingScooterPage orderingScooterPage = new OrderingScooterPage(driver);
        orderingScooterPage.inputAddress("1");
        Assert.assertTrue("Не отображается ошибка Адреса", orderingScooterPage.checkCorrectAddress());
    }

    @Test
    public void corrStation() {
        OrderingScooterPage orderingScooterPage = new OrderingScooterPage(driver);
        Assert.assertTrue("Не отображается ошибка Станция не выбрана", orderingScooterPage.checkCorrectStation());
    }

    @Test
    public void corrPhoneNumber() {
        OrderingScooterPage orderingScooterPage = new OrderingScooterPage(driver);
        Assert.assertTrue("Не отображается ошибка Номера телефона", orderingScooterPage.checkPhoneNumber());
    }
}
