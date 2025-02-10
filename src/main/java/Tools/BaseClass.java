package Tools;

import Utils.ObjectGenerator;
import Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {


    public static ThreadLocal<WebDriver> Driver = new ThreadLocal<>();
    public static ThreadLocal<ObjectGenerator> OBJ = new ThreadLocal<>();


    public static WebDriver init_driver(String browser) {


        System.out.println("browser value is: " + browser);
        OBJ.set(new ObjectGenerator());
        if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().clearResolutionCache();
//            WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            Driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().clearResolutionCache();
            WebDriverManager.firefoxdriver().setup();
            Driver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("IE")) {
            Driver.set(new InternetExplorerDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().window().maximize();
        getDriver().get(PropertyReader.getProperty("url"));
        return getDriver();

    }


    public static WebDriver getDriver() {
        return Driver.get();
    }

    public static synchronized ObjectGenerator getObjectGenerator() {
        return OBJ.get();
    }


}
