package orangehrm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrangeHrmLive {
    static String browser = "Firefox";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //Open URL
        driver.get(baseUrl);
        //Maximize the window
        driver.manage().window().maximize();
        //Timeout for hold the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Print the title of the page.
        System.out.println(driver.getTitle());
        //Print the current url.
        System.out.println(driver.getCurrentUrl());
        //Print the page source
        System.out.println(driver.getPageSource());
        //Click on ‘Forgot your password?’ link.
        WebElement pass = driver.findElement(By.className("orangehrm-login-forgot-header"));
        pass.click();
        //Print current URL
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5_000);
        //Navigate back to the login page.
        driver.navigate().to(baseUrl);
        //Refresh the page
        driver.navigate().refresh();
        //Enter the email to email field
        driver.findElement(By.name("username")).sendKeys("Admin");
        //Enter the password field
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click on login button
        WebElement login = driver.findElement(By.className("orangehrm-login-button"));
        login.click();
        //close the browser
        driver.quit();

    }


}

