import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import javax.swing.text.Document;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

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

        driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");
        Thread.sleep(1000);

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Grade Report.pdf"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        document.addTitle("Grade Report ");

        document.open();
        Paragraph paragraph=new Paragraph();
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover']//tr"));
// for every line, store both columns
        for (WebElement row : rows) {
            WebElement key = row.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/table/tbody[1]"));
            System.out.println(key.getText());
            paragraph.add(key.getText());
            try {
                document.add(paragraph);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            break;
        }
        document.close();
        driver.close();
    }
// Go back to Home Page
        //   driver.navigate().back();
// Go forward to Registration page
        //    driver.navigate().forward();
// Go back to Home page
        //    driver.navigate().to(appUrl);
// Refresh browser
        //    driver.navigate().refresh();
// Close browser

    }