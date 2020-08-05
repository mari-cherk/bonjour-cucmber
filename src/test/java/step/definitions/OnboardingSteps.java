package step.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.OnboardingPage;
import pages.PrivacyPolicyPage;
import pages.TermsOfUsePage;
import utils.DeviceService;

import static org.assertj.core.api.Assertions.assertThat;
import static step.Hooks.getDriver;

public class OnboardingSteps {

    private OnboardingPage onboardingPage = new OnboardingPage();
    private TermsOfUsePage termsOfUsePage = new TermsOfUsePage();
    private PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();


    @Given("^I am on the \"Welcome\" screen$")
    public void iAmOnTheScreen() {
        assertThat(onboardingPage.isContinueButtonPresent()).isEqualTo(true);
    }

    @When("^I tap the \"Continue\" button$")
    public void iTapTheButton() {
        onboardingPage.tapContinueButton();
    }

    @Then("^the \"(Terms of use|Privacy Policy)\" screen should be opened$")
    public void theScreenShouldBeOpened(String screenName) {
        if ("Terms of use".equalsIgnoreCase(screenName)) {
            assertThat(termsOfUsePage.isTermsPageOpened()).isEqualTo(true);
        } else {
            assertThat(privacyPolicyPage.isPrivacyPolicyPageOpened()).isEqualTo(true);
        }
    }

    @Given("^I am launching the application for the first time$")
    public void iAmLaunchingTheApplicationForTheFirstTime() {
        DeviceService deviceService = new DeviceService(getDriver());
        deviceService.removeApp();
        deviceService.installNewBuild();
    }

    @When("^I tap the \"Terms of service\" link$")
    public void iTapTheTermsLink() {
        onboardingPage.tapTermsOfServiceLink();
    }

    @When("^I tap the \"Privacy Policy\" link$")
    public void iTapThePrivacyLink() {
        onboardingPage.tapPrivacyPolicyLink();
    }
}
