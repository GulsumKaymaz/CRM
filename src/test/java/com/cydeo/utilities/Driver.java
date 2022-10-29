package com.cydeo.utilities;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import java.util.concurrent.*;

public class Driver {

    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver() {
    }

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
    private static WebDriver driver; // value is null by default

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver() {

        if (driver == null) {

            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");


            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;


            }
        }

        return driver;

    }

    // driver.quit() ---> NoSuchSessionException: Session ID is null.
    // driver.close() ---> NoSuchSessionException: invalid session id
    // Try to create a method named closeDriver()

    /*
   This method will make sure our driver value is always null after using quit() method
   because to create driver object we use Singleton design pattern. This pattern demands to us driver to be "null"
   otherwise that method can not run. To make our driver "null" again, right after closing it by using quit() or close()
   method we need one more method. In this way we are able to run every single test from scratch.
    */
    public static void closeDriver(){
        if (driver != null){
            driver.quit(); // this line will terminate the existing session. value will not even be null
            driver = null;

        }
    }
}


