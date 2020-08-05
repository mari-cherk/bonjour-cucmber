package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static step.Hooks.getDriver;

public class TermsOfUsePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of Use']")
    private MobileElement screenTitle;
    @AndroidFindBy(xpath = "//android.webkit.WebView")
    private MobileElement webViewWithConsentText;

    public TermsOfUsePage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public boolean isTermsPageOpened() {
        waitToBeVisible(webViewWithConsentText);
        System.out.println(webViewWithConsentText.getText());
        return isElementPresent(screenTitle) && isElementPresent(webViewWithConsentText);
    }
}
