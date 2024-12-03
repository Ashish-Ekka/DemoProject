package com.test.demoproject;

import com.main.demoproject.webuitesting.driversetup.BaseClass;
import com.main.demoproject.webuitesting.saucelab_pagelocator.SauceLabLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebLogin extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        launchapplicaton("webapplication");
        SauceLabLoginPage sauceLabLoginPage = new SauceLabLoginPage();
        String urlBeforeLogin = driver.getCurrentUrl();
        Assert.assertTrue(sauceLabLoginPage.enterUserName());
        Assert.assertTrue(sauceLabLoginPage.enterPassword());
        Assert.assertTrue(sauceLabLoginPage.clickOnSubmit());
        String urlAfterLogin = driver.getCurrentUrl();
        Assert.assertNotEquals(urlBeforeLogin,urlAfterLogin);

    }
}
