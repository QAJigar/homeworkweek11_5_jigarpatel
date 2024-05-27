package testsuite;
/**
 * Created by Jigar Patel
 */
import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    //1. userShouldNavigateToLoginPageSuccessfully *
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Verify the text ‘Welcome Back!’
        String expectedText="Welcome Back!";
        String actualText=driver.findElement(By.className("page__heading")).getText();
        Assert.assertEquals("Text Not Found", expectedText,actualText);
    }

    @Test  //if status Test fail is problem to "image comparison" not supported selenium.
    //2. verifyTheErrorMessage
    public void verifyTheErrorMessage(){
        //* click on the ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        //* Enter invalid username
        driver.findElement(By.name("user[email]")).sendKeys("Prim123@gml.com");
        //* Enter invalid password
        driver.findElement(By.name("user[password]")).sendKeys("prmime123");
        //* Click on Login button
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha'] ")).click();
        //* Verify the error message ‘Invalid email or password.
        String expectedText="Invalid email or password";
        String actualText=driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Message not Valid", expectedText,actualText);

        //if status gone fail is problem "image comparison" not supported selenium.

    }
    public void tearDown(){
        driver.quit();
    }
}
