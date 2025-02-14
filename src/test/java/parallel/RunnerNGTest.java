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
import java.util.logging.Logger;


@CucumberOptions(features = "src/test/resources/parallel",
        glue = {"parallel"},
        plugin = {"pretty", "html:testoutput/testReport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = true,
        monochrome = true,
        tags = "not @Skip"
)

public class RunnerNGTest extends AbstractTestNGCucumberTests {
    Logger log = Logger.getLogger(RunnerNGTest.class.getName());

    protected WebDriver driver;
    private static final ThreadLocal<String> runtype = new ThreadLocal<>();

    @Parameters({"BrowserType","RunType"})
    @BeforeClass
    public void LaunchBrowser(@Optional("Chrome") String browser,@Optional("UI") String Runtype){
        runtype.set(Runtype);
        log.info("Running Tags are : "+getTags());
        if (runtype.get().equalsIgnoreCase("UI") || runtype.get().equalsIgnoreCase("BOTH")) {
            log.info("************************* Launching browser*****************************");
            driver = BaseClass.getInstance().init_driver(browser);
        }else {
            log.info("************************* Running Api Test *****************************");
        }

    }
    private String getTags(){
        switch (runtype.get().toUpperCase()){
            case "API": return "@API";
            case "UI": return "@UI";
            case "BOTH": return "not @Skip"; // Runs both @UI and @API
            default: return "@UI";
        }
    }

    @AfterClass(alwaysRun = true)
    public void teardown(ITestContext context) throws IOException {
        if (runtype.get().equalsIgnoreCase("API")){
            log.info("********************* No Screen Shot Required ********************");
            return;
        }
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
        if (runtype.get().equalsIgnoreCase("UI") || runtype.get().equalsIgnoreCase("BOTH")) {
            log.info("************************* Browser got closed*****************************");
            BaseClass.quitDriver();
        }
    }



}
