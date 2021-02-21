package Screens;

import com.eribank.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ScreenLogIn extends TestBase {

    public ScreenLogIn(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(id = "usernameTextField")
    MobileElement txtUserName;

    @AndroidFindBy(id = "passwordTextField")
    MobileElement txtPassword;

    @AndroidFindBy(id = "loginButton")
    MobileElement btnLogIn;

    public void logIn(String userName, String password){
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogIn.click();
    }
}
