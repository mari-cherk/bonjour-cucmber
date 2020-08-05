package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;

import static step.Hooks.getDriver;

public class OnboardingPage extends BasePage {
    @AndroidFindBy (id = "com.fsof.test:id/submitBtn")
    private MobileElement continueButton;
    @AndroidFindBy (id = "com.fsof.test:id/termsAndPrivacyTxt")
    private MobileElement termsLink;

    public OnboardingPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public void tapContinueButton() {
        tapElement(continueButton);
    }

    public boolean isContinueButtonPresent() {
        return isElementPresent(continueButton);
    }

    public void tapTermsOfServiceLink() {
        waitToBeVisible(termsLink);
        Point p = termsLink.getCenter();
        tapAt(p.getX(), p.getY());
    }

    public void tapPrivacyPolicyLink() {
        waitToBeVisible(termsLink);
        // terms and privacy policy links are one elements in UI tree, so we need to tap by coordinates
        Dimension windowSize = getDriver().manage().window().getSize();
        // we need approx 25% to the left from element center to hit correct link
        int offset = windowSize.getWidth() * 25 / 100;
        Point p = termsLink.getCenter();
        tapAt(p.getX() + offset, p.getY());
    }
}
