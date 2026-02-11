import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginToLearningMaterials {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void startBrowser() throws InterruptedException {
        driver.get("https://ndosiautomation.co.za/#practice");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void verifyLoginHeading() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(visibilityOf(driver.findElement(By.xpath("//*[@id=\"login-heading\"]"))));
        driver.findElement(By.xpath("//*[@id=\"login-heading\"]")).isDisplayed();
    }

    @Test(priority = 2)
    public void enterUsername() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"login-email\"]")).sendKeys("seritej@gmail.com");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void enterPassword() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"login-password\"]")).sendKeys("Jules88082@");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"login-submit\"]")).click();
        Thread.sleep(3000);
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
