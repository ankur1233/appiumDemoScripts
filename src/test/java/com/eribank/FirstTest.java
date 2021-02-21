package com.eribank;

import Screens.ScreenLogIn;
import Screens.ScreenMain;
import Screens.ScreenPayment;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

public class FirstTest extends TestBase{

    @Test
    public void test() throws Exception{

        ScreenLogIn screenLogIn = new ScreenLogIn();
        screenLogIn.logIn("company", "company");

        ScreenMain screenMain = new ScreenMain();
        screenMain.logBalanceData();
        int initialBalance = Integer.parseInt(screenMain.getBalance());
        screenMain.clickPaymentButton();

        ScreenPayment screenPayment = new ScreenPayment();
        screenPayment
                .setPhoneNumber("55555555555")
                .setName("Emre Can")
                .setAmount("2")
                //.verifyError("En az 3 girilmelidir.")
                .clickCountrySelect()
                .selectCountry("Canada")
                .clickSendPayment()
                .clickYesButton();

        screenMain.logBalanceData();

        screenMain
                .compareBalances(initialBalance,2)
                .clickLogout();
    }



    @Test
    public void checkboxTest() {

        getDriver().findElementByAccessibilityId("Preference").click();
        getDriver().findElementByAccessibilityId("1. Preferences from XML").click();
        MobileElement checkbox = getDriver().findElementByXPath("(//android.widget.CheckBox)[1]");

        System.out.println("Initial State: " + checkbox.getAttribute("checked"));

        checkbox.click();

        System.out.println("Second State: " + checkbox.getAttribute("checked"));
    }
}
