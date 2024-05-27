package browserfactory;
/**
 * Created by Jigar Patel
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        //launch Chrome browser
        driver = new ChromeDriver();
        //open browser
        driver.get(baseUrl);
        //maximize browser
        driver.manage().window().maximize();
        //implicit time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.quit();
    }
}
