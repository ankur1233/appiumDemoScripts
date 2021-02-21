package Screens;

        import com.eribank.TestBase;
        import io.appium.java_client.MobileBy;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;
        import org.openqa.selenium.support.PageFactory;

        import java.time.Duration;

public class ScreenPayment extends TestBase {

    public ScreenPayment(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(id = "phoneTextField")
    MobileElement txtPhone;

    @AndroidFindBy(id = "nameTextField")
    MobileElement txtName;

    @AndroidFindBy(id = "amount")
    MobileElement barAmount;

    @AndroidFindBy(id = "countryButton")
    MobileElement btnCountry;

    @AndroidFindBy(id = "sendPaymentButton")
    MobileElement btnSendPayment;

    @AndroidFindBy(id = "android:id/button1")
    MobileElement btnYes;

    public ScreenPayment setPhoneNumber(String phoneNumber){
        txtPhone.setValue(phoneNumber);
        return this;
    }

    public ScreenPayment setName(String name){
        txtName.setValue(name);
        return this;
    }

    public ScreenPayment setAmount(String amount){
        barAmount.setValue(amount);
        return this;
    }

    public ScreenPayment clickCountrySelect(){
        btnCountry.click();
        return this;
    }

    public ScreenPayment clickSendPayment(){
        btnSendPayment.click();
        return this;
    }

    public ScreenPayment selectCountry(String countryName){
        //swipe until find the country name
        MobileElement swipeElement = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\""+ countryName +"\"))"));

        getDriver().findElementByXPath("//android.widget.TextView[@text='"+countryName+"']").click();
        return this;
    }

    public ScreenPayment clickYesButton(){
        btnYes.click();
        return this;
    }


}
