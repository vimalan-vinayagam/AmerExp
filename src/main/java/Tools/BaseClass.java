package Tools;

import Utils.ObjectGenerator;
import Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


    public class BaseClass {
        private static BaseClass instance =null;
        private static ThreadLocal<WebDriver> Driver = new ThreadLocal<>();
        private static ThreadLocal<ObjectGenerator> OBJ = new ThreadLocal<>();

        private BaseClass(){}
        public static BaseClass getInstance(){
            if (instance==null){
                instance = new BaseClass();
            }
            return instance;
        }
        public WebDriver init_driver(String browser) {
            System.out.println("Browser value is: " + browser);
            OBJ.set(new ObjectGenerator());

            if (browser.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().clearResolutionCache();
//            WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                Driver.set(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                Driver.set(new FirefoxDriver());
            } else if (browser.equalsIgnoreCase("IE")) {
                WebDriverManager.iedriver().setup();
                Driver.set(new InternetExplorerDriver());
            } else {
                System.out.println("❌ Please pass the correct browser value: " + browser);
                return null;
            }

            getDriver().manage().window().maximize();
            getDriver().get(PropertyReader.getProperty("url"));
            return getDriver();
        }

        public static WebDriver getDriver() {
            if (Driver.get() == null) {
                throw new IllegalStateException("Driver is not initialized. Call init_driver() first.");
            }
            return Driver.get();
        }

        public static synchronized ObjectGenerator getObjectGenerator() {
            return OBJ.get();
        }

        public static void quitDriver() {
            if (Driver.get() != null) {
                getDriver().quit();
                Driver.remove();
            }
        }
    }
