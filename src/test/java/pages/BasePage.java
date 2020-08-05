package pages;

import java.time.Duration;

import common.ProjectConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.offset.PointOption.point;
import static step.Hooks.getDriver;

public class BasePage {
    protected WebDriverWait wait;
    protected Wait<WebDriver> fluentWait;

    public BasePage() {
        wait = new WebDriverWait(getDriver(), ProjectConfig.TIMEOUT);
    }

    protected void tapElement(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitToBeVisible(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isElementPresent(MobileElement element) {
        boolean elementFound;
        try {
            waitToBeVisible(element);
            elementFound = true;
        } catch (NoSuchElementException | TimeoutException e) {
            elementFound = false;
        }
        return elementFound;
    }

    protected void tapAt(final int widthX, final int heightY) {
        TouchAction touchAction = new AndroidTouchAction(getDriver());
        touchAction.tap(point(widthX, heightY));
        getDriver().performTouchAction(touchAction);
    }

    protected void baseSwipe(int startX, int startY, int endX, int endY) {
        new TouchAction<>(getDriver())
                .press(new PointOption().withCoordinates(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(new PointOption().withCoordinates(endX, endY))
                .release()
                .perform();
    }

    protected void scrollDown(int count) {
        Dimension dimension = getDriver().manage().window().getSize();
        int startX = dimension.getWidth() / 2;
        int startY = (int) (dimension.getHeight() * 0.6);
        int endY = (int) (dimension.getHeight() * 0.3);
        for (int i = 0; i < count; i++) {
            baseSwipe(startX, startY, startX, endY);
        }
    }

    protected void scrollUp(int count) {
        Dimension dimension = getDriver().manage().window().getSize();
        int startX = dimension.getWidth() / 2;
        int startY = (int) (dimension.getHeight() * 0.3);
        int endY = (int) (dimension.getHeight() * 0.6);
        for (int i = 0; i < count; i++) {
            baseSwipe(startX, startY, startX, endY);
        }
    }

    protected void scrollDownToElement(MobileElement element) {
        for (int i = 0; i < 10; i++) {
            try {
                waitToBeVisible(element);
                break;
            } catch (NoSuchElementException | TimeoutException e) {
                scrollDown(2);
            }
        }
        // to scroll card into view fully
        scrollDown(1);
    }
}
