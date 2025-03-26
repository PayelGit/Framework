package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {


    @Before
    public void setUp()
    {
        BaseClass.initializeBrowser();
    }

    @After
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            BaseClass.takeScreenshot(scenario.getName());
        }
        BaseClass.closeBrowser();
    }

}
