package utils;

import java.awt.*;
import java.nio.file.Paths;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Dimension;

public class DeviceService {
    private final MobileDriver<MobileElement> driver;
    private static final String APP_PATH = Paths.get("src", "main", "resources", "app.apk").toAbsolutePath().toString();

    public DeviceService(final MobileDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void removeApp() {
        System.out.println("Uninstalling application...");
        driver.removeApp(APP_PATH);
    }

    public void installNewBuild() {
        this.removeApp();
        this.driver.installApp(APP_PATH);
        this.driver.launchApp();
    }

    public Dimension getScreenDimensions() {
        return driver.manage().window().getSize();
    }
}
