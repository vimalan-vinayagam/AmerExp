package parallel;
import Tools.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
        driver = BaseClass.init_driver(Browser);

    }
    @AfterClass
    public void teardown() {
        log.info("************************* Browser got closed*****************************");
        driver.quit();
    }

    @AfterClass
    public void screenShot(ITestContext context) throws IOException {
        if (context.getFailedTests().size() > 0) {
            log.info("************************* Screen shot for failed test cases*****************************");
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("failedImp/screenshot.png");
            Files.copy(src.toPath(), dest.toPath());

        }
    }

}
