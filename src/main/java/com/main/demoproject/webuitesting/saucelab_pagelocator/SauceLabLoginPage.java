package com.main.demoproject.webuitesting.saucelab_pagelocator;

import com.main.demoproject.webuitesting.driversetup.BaseClass;
import com.main.demoproject.webuitesting.utility.PropertiesUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SauceLabLoginPage extends BaseClass {

    private static final Logger log = LoggerFactory.getLogger(SauceLabLoginPage.class);

    public SauceLabLoginPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "input#user-name")
    private WebElement userNameLocator;

    @FindBy(css = "input#password")
    private WebElement passwordLocator;

    @FindBy(css = "input#login-button")
    private WebElement loginButton;

    public boolean enterUserName() {

        try {
            String userName = PropertiesUtility.readFromPropertiesFile("username");

            if (userName == null || userName.isEmpty()) {
                throw new IllegalArgumentException("The username value is missing or empty in the properties file.");
            }
            userNameLocator.sendKeys(userName);
            return true;

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }


    }

    public boolean enterPassword() {

        try {
            String password = PropertiesUtility.readFromPropertiesFile("password");

            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("The password value is missing or empty in the properties file.");
            }
            passwordLocator.sendKeys(password);
            return true;

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean clickOnSubmit() {
        try {
            if (!loginButton.isEnabled()) {
                throw new IllegalStateException("Login button is not enabled and cannot be clicked.");
            }

            loginButton.click();
            return true;

        } catch (Exception e) {
            System.err.println("Failed to click the submit button: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
