package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static step.Hooks.getDriver;

public class ContestsPage extends BasePage {
    @AndroidFindBy(id = "com.fsof.test:id/sortBtn")
    private MobileElement sortButton;
    @AndroidFindBy(id = "com.fsof.test:id/allContestsBtn")
    private MobileElement allContestsButton;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@resource-id,'contestView')]")
    private MobileElement contestContainer;
    @AndroidFindBy(id = "com.fsof.test:id/videoTimeTxt")
    private MobileElement videoTimeTag;
    @AndroidFindBy(id = "com.fsof.test:id/contestEnterBtn")
    private MobileElement enterNowButton;
    @AndroidFindBy(id = "com.fsof.test:id/contestStateTxt")
    private MobileElement contestStateLabel;

    public ContestsPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public String getFirstVideoTimeTag() {
        return videoTimeTag.getText();
    }

    public void tapSortButton() {
        tapElement(sortButton);
    }

    public void scrollToContest() {
        scrollDownToElement(contestContainer);
    }

    public boolean isRequiredContestElementsVisible() {
        return isElementPresent(enterNowButton)
                && isElementPresent(contestStateLabel)
                && contestStateLabel.getText().contains("Live");
    }

    public boolean isContestsScreenOpened() {
        return isElementPresent(sortButton) && isElementPresent(allContestsButton);
    }
}
