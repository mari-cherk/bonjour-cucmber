package pages.modals;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import static step.Hooks.getDriver;

public class IntroducingContestsModal extends BasePage {

    @AndroidFindBy (id = "com.fsof.test:id/titleTxt")
    private MobileElement introducingContestsModalTitle;
    @AndroidFindBy (id = "com.fsof.test:id/submitBtn")
    private MobileElement gotItButton;

    public IntroducingContestsModal() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public void tapGotItButton() {
        tapElement(gotItButton);
    }

    public boolean isContestsModalDisplayed() {
        return isElementPresent(introducingContestsModalTitle)
                && isElementPresent(gotItButton)
                && introducingContestsModalTitle.getText().equalsIgnoreCase("Introducing Contests");
    }
}
