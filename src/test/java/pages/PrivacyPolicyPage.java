package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static step.Hooks.getDriver;

public class PrivacyPolicyPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private MobileElement screenTitle;
    @AndroidFindBy(xpath = "//android.webkit.WebView")
    private MobileElement webViewWithConsentText;

    public PrivacyPolicyPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public boolean isPrivacyPolicyPageOpened() {
        return isElementPresent(screenTitle) && isElementPresent(webViewWithConsentText);
    }
}
