package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;
    public static void loadConfig()
    {
        try
        {
            prop = new Properties();
            FileInputStream file = new FileInputStream("src/test/resources/global.properties");
            prop.load(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void initializeBrowser()
    {
        loadConfig();
        String browser = prop.getProperty("browser");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--headless");
        if(browser.equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver(opt);
        }
        else if(browser.equalsIgnoreCase("Firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            driver = new EdgeDriver();
        }
        else {
            throw new RuntimeException("Browser not supported");
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    public static void takeScreenshot(String scenarioName)
    {
        try
        {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("target/screenshots/"+ scenarioName + ".png"));
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeBrowser()
    {
        if(driver!=null)
        {
            driver.close();
        }

    }

}
