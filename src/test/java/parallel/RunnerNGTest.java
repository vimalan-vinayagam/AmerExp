package parallel;
import Tools.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@CucumberOptions(features = "src/test/resources/parallel",
        glue = {"parallel"},
        plugin = {"pretty", "html:testoutput/testReport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//        dryRun = true,
        monochrome = true

)

public class RunnerNGTest extends AbstractTestNGCucumberTests {
    Logger log = Logger.getLogger(RunnerNGTest.class.getName());

    protected WebDriver driver;

    @Parameters("BrowserType")
    @BeforeClass
    public void LaunchBrowser(@Optional("Chrome") String Browser){
        log.info("************************* Launching browser*****************************");
        driver = BaseClass.getInstance().init_driver(Browser);

    }

    @AfterClass
    public void teardown(ITestContext context) throws IOException {
        if (!context.getFailedTests().getAllResults().isEmpty()) {
            log.info("************************* Screen shot for failed test cases*****************************");
            File dest = new File("failedImp/screenshot_" + System.currentTimeMillis() + ".png");
            if (!dest.getParentFile().exists()) {
                boolean created = dest.getParentFile().mkdirs();
                log.info("Directory created: " + created);
            }
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), dest.toPath());
        }

        log.info("************************* Browser got closed*****************************");
        BaseClass.quitDriver();
    }

}
