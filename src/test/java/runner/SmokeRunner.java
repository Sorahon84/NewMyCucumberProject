package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        //when it is true, it generates step def which is missing
        //when it is false, it executes the code
        dryRun = false,
        tags = "@smoke",
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"}
)
public class SmokeRunner {
}
