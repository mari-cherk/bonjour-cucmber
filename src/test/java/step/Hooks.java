package step;

import common.ProjectConfig;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;


public class Hooks {
    protected static AppiumDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (ProjectConfig.DEVICE_OS.equalsIgnoreCase("Android")) {
            capabilities.setCapability("platformName", "Android");
            //capabilities.setCapability("deviceName", "AEJ7N18911003704");
            capabilities.setCapability("deviceName", "ba0d11b");
            capabilities.setCapability("appPackage", "com.fsof.test");
            capabilities.setCapability("appActivity", "com.fsof.presentation.main_screen.MainActivity");
            capabilities.setCapability("app", Paths.get("src", "main", "resources", "app.apk").toAbsolutePath().toString());

            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else if (ProjectConfig.DEVICE_OS.equalsIgnoreCase("iOS")) {
            // todo implement IOS driver init
        } else {
            throw new InvalidArgumentException("Unknown driver implementation requested");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static MobileDriver<MobileElement> getDriver() {
        return driver;
    }
}
