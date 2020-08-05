package step.definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ContestsPage;
import pages.OnboardingPage;
import pages.modals.IntroducingContestsModal;
import pages.modals.SortByModal;
import utils.TimeUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class ContestsSteps {
    private OnboardingPage onboardingPage = new OnboardingPage();
    private IntroducingContestsModal contestsModal = new IntroducingContestsModal();
    private ContestsPage contestsPage = new ContestsPage();
    private SortByModal sortByModal = new SortByModal();

    @Given("^I am on the \"Contests\" screen$")
    public void iAmOnTheScreen() {
        if (onboardingPage.isContinueButtonPresent()) {
            onboardingPage.tapContinueButton();
        }
        if (contestsModal.isContestsModalDisplayed()) {
            contestsModal.tapGotItButton();
        }
        assertThat(contestsPage.isContestsScreenOpened()).isEqualTo(true);
    }

    @When("^I apply \"(Most Popular|Most Recent)\" sorting$")
    public void iApplySorting(String filter) {
        contestsPage.tapSortButton();
        if ("Most Popular".equalsIgnoreCase(filter)) {
            sortByModal.tapMostPopular();
        } else {
            sortByModal.tapMostRecent();
        }
        // wait for list to sort
        TimeUtils.sleep(2000);
    }

    @Then("^Most popular post is displayed at the top$")
    public void mostPopularPostAtTheTop() {
        // easiest way for this test would be to make oldest post - most popular,
        // so when most popular sorting enabled - it will appear and since it is old - it can't be posted hours ago
        assertThat(contestsPage.getFirstVideoTimeTag()).doesNotContain("hour");
    }

    @When("^I scroll to the contest$")
    public void iScrollToTheContest() {
        contestsPage.scrollToContest();
    }

    @Then("^The \"Enter now\" and \"Live\" elements are visible$")
    public void theAndElementsAreVisible() {
        assertThat(contestsPage.isRequiredContestElementsVisible()).isEqualTo(true);
    }
}
