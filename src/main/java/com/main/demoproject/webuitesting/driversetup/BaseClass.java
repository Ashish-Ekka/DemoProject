package com.main.demoproject.webuitesting.driversetup;

import com.main.demoproject.webuitesting.utility.PropertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    public void initializeDriver() throws IOException {

        String browserName = PropertiesUtility.readFromPropertiesFile("browser");

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--disable-notifications");
                driver = new ChromeDriver(option);

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
        }
    }

    public void launchapplicaton(String applicationName) throws IOException {
        initializeDriver();
        String url = PropertiesUtility.readFromPropertiesFile(applicationName);
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void terminate() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
