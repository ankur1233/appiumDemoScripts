package com.freeData;

import Screens.AppScreen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetFreeDataScript extends TestBase{

    AppScreen screenLogIn;

    @BeforeMethod()
    public void setupApp(){
        screenLogIn = new AppScreen();
    }

    @Test
    public void selectFreeData() {

        screenLogIn.enterUserName("Hello").
                enterMobileNumber("878767898").clickOnNext().
                enterNetwork("AT").clickOnNext()
                .enterCountry("LalaLand").clickOnNext().
                         selectDataType("MB").    //GB, MB
                            selectDataOffer("23 MB");  //80 MB,25 MB,23 MB

    }


}
