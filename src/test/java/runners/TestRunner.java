package runners;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features="src/test/java/features",
        glue ={"stepDefinitions", "hooks"},
//        dryRun = true,
        plugin = {"pretty", "html:target/cucumber-report.html"}

)


public class TestRunner extends AbstractTestNGCucumberTests {

//    @Override
//    @DataProvider(parallel=true)
//    public Object[][] scenarios()
//    {
//        return super.scenarios();
//    }
}
