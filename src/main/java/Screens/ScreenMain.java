package Screens;

        import com.eribank.TestBase;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.pagefactory.AndroidFindBy;
        import io.appium.java_client.pagefactory.AppiumFieldDecorator;
        import org.openqa.selenium.support.PageFactory;
        import org.testng.Assert;

        import java.time.Duration;

public class ScreenMain extends TestBase {

    public ScreenMain(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(xpath = "//android.webkit.WebView/android.view.View[contains(@text, 'Your balance is')]")
    MobileElement lblBalance;

    @AndroidFindBy(id = "makePaymentButton")
    MobileElement btnPayment;

    @AndroidFindBy(id = "logoutButton")
    MobileElement btnLogout;

    public void clickPaymentButton(){
        btnPayment.click();
    }

    public void clickLogout(){
        btnLogout.click();
    }

    public void logBalanceData(){
        System.out.println("Initial Balance: " + getBalance());
    }

    public String getBalance(){
        String txtBalance = lblBalance.getText();
        String balance = txtBalance.replace("Your balance is: ","")
                .replace(",00$","");

        return balance;
    }

    public ScreenMain compareBalances(int initialBalance, int consumedAmount)
    {
        int currentBalance = Integer.parseInt(getBalance());
        int expectedBalance = initialBalance - consumedAmount;

        Assert.assertEquals(currentBalance, expectedBalance, "Güncel Bakiye Bilgisi Doğru Değil!");

        return this;
    }
}
