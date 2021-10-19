package Screens;

import com.freeData.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class AppScreen extends TestBase {

    public AppScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(30)), this);
    }

    @AndroidFindBy(id = "edt_name")
    MobileElement txtUserName;

    @AndroidFindBy(id = "edt_mob_num")
    MobileElement enterMobileNumber;

    @AndroidFindBy(id = "btn_next")
    MobileElement mobileNext;

    @AndroidFindBy(id = "namenextbtn")
    MobileElement nextBtn;

    @AndroidFindBy(xpath = "//*[@text='X']")
    List<MobileElement> closeX;

    @AndroidFindBy(xpath = "//*[@text='No Thanks']")
    List<MobileElement> closeNoThanks;


    @AndroidFindBy(id = "edt_sim_network")
    MobileElement simNetwork;

    @AndroidFindBy(id = "edt_countryName")
    MobileElement countryName;

    String dataType = "//*[@text='%s']";

    @AndroidFindBy(id = "btn_fifteen_MB")
    MobileElement dataInMB;

    public void handleAds(){

          try {
            if (closeX.size()!=0) {
                closeX.get(0).click();
                System.out.println("Add Found");
            }

            else{
                  closeNoThanks.get(0).click();
                  System.out.println("Add Found");
              }

        }catch (Exception e){



        }
        System.out.println("Add Found");

    }


    public AppScreen enterUserName(String name){
        handleAds();
        txtUserName.sendKeys(name);
        nextBtn.click();
        return this;
    }
    public AppScreen enterMobileNumber(String number){
      handleAds();
       /*
        getDriver().startActivity(new Activity("best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew",
                "best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew.MobNumActivity"));
*/
        enterMobileNumber.sendKeys(number);

        return this;
    }

    public AppScreen enterNetwork(String network){
        handleAds();
/*

        getDriver().startActivity(new Activity("best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew",
                "best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew.NetActivity"));

*/

        simNetwork.sendKeys(network);
        return this;
    }

    public AppScreen enterCountry(String country){
       handleAds();
/*

        getDriver().startActivity(new Activity("best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew",
                "best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew.CountryListActivity"));
*/

        countryName.click();
        countryName.sendKeys(country);
        return this;
    }

    public AppScreen selectDataType(String data){
      //  handleAds();

/*
        getDriver().startActivity(new Activity("best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew",
                "best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew.MbAndGBActivity"));

*/

        try {
            Thread.sleep(2000);
        }catch (Exception e){}
        getDriver().findElement(By.xpath(String.format(dataType,data))).click();
        return this;
    }

    public AppScreen selectDataOffer(String offer){
     //   handleAds();


     /*   getDriver().startActivity(new Activity("best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew",
                "best_freeinternet.free_internetdata_50GB_internet_prank.FreeData_guidenew.MbbActivity"));

*/

        try {
            Thread.sleep(1000);
            getDriver().findElement(By.xpath(String.format(dataType,offer))).click();
            Thread.sleep(3000);
        }catch (Exception e){}

        return this;
    }

    public AppScreen clickOnNext(){
       //handleAds();
        mobileNext.click();
        return this;
    }

}
