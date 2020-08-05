package pages.modals;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import static step.Hooks.getDriver;

public class SortByModal extends BasePage {
    @AndroidFindBy(id = "com.fsof.test:id/mostRecentBtn")
    private MobileElement mostRecentButton;
    @AndroidFindBy(id = "com.fsof.test:id/mostPopularBtn")
    private MobileElement mostPopularButton;

    public SortByModal() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public void tapMostRecent() {
        tapElement(mostRecentButton);
    }

    public void tapMostPopular() {
        tapElement(mostPopularButton);
    }
}
