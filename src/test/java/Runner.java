import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        strict = true,
        monochrome = true,
        glue = "step",
        tags = {"@smoke"})
public class Runner {
}