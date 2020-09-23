package CukesRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
        @CucumberOptions(
                features = "/Users/yerzhanalmayev/IdeaProjects/CucumberBatch5/src/test/resources/WebOrderTests/LoginFunctionality.feature",
        glue = "StepDefinition",
        tags = "@TEC-1020",
        dryRun = false

        )
public class Runner {
    }

