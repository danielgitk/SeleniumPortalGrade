import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class portalLogin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
// Create a new instance of the Chrome driver
        ChromeOptions options = new ChromeOptions().setBinary("C:\\Program Files (x86)\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        WebDriver driver = new ChromeDriver(options);
// Open ToolsQA web site
        String appUrl = "https://portal.aait.edu.et";
        driver.get(appUrl);
// Click on Registration link
        driver.findElement(By.id("UserName")).sendKeys("ATR/8104/09");
        driver.findElement(By.id("Password")).sendKeys("9629");
        Thread.sleep(9);
        driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);

// Go back to Home Page
        //   driver.navigate().back();
// Go forward to Registration page
        //    driver.navigate().forward();
// Go back to Home page
        //    driver.navigate().to(appUrl);
// Refresh browser
        //    driver.navigate().refresh();
// Close browser
        //   driver.close();
    }}