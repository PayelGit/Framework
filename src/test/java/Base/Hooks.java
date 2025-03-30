package Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {


    @Before(order=1)
    public void setUp()
    {
        BaseClass.initializeBrowser();
    }
    @Before(order=2)
    public void setUp2()
    {
        System.out.println("2nd before is running");;
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
    @After
    public void tearDown2(Scenario scenario)
    {
        System.out.println("2nd after is running");
    }

}
