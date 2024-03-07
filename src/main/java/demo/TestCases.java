package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().browserVersion("122.0.6261.95").setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");

        String url = driver.getCurrentUrl();
        String expected = "https://www.google.com";

        if (url.contains(expected)) {
            System.out.println("Verifying url displays");

        }

        WebElement searchBar = driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
        searchBar.sendKeys("calculator");
        searchBar.submit();
        WebElement textZero = driver.findElement(By.xpath("//div[@jsname='DjP6yd']/div"));

        String title0 = textZero.getText();
        String expectedValue = "0";

        if (title0.contains(expectedValue)) {
            System.out.println("Verifying: " + expected);

        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("Start Test case: testCase02");
        driver.get("https://www.google.com");

        // String url = driver.getCurrentUrl();
        // String expected = "https://www.google.com";

        // if (url.contains(expected)) {
        // System.out.println("Verifying url displays");

        // }
        // System.out.println("Performing Addition Operation");

        WebElement searchBar = driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
        searchBar.sendKeys("calculator");
        searchBar.submit();
        Thread.sleep(2000);
        System.out.println("Performing Addition Operation");
        WebElement valueFive = driver.findElement(By.xpath("//div[@class='PaQdxb A2W7l']/div[text()='5']"));
        valueFive.click();
        WebElement valuePlus = driver.findElement(By.xpath("//div[@class='PaQdxb mF5fo']/div[text()='+']"));
        valuePlus.click();
        WebElement valueSeven = driver.findElement(By.xpath("//div[@class='PaQdxb A2W7l']/div[text()='7']"));
        valueSeven.click();
        WebElement valueEqual = driver.findElement(By.xpath("//div[@class='PaQdxb mF5fo G7BHUb']/div[text()='=']"));
        valueEqual.click();
        WebElement result = driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span"));
        String actualResult = result.getText();
        String expectedResult = "12";

        if (actualResult.contains(expectedResult)) {
            System.out.println("Verifying: " + expectedResult);

        }
        WebElement removeAll = driver.findElement(By.xpath("//div[@jsname='SLn8gc']"));
        removeAll.click();
        Thread.sleep(2000);

        System.out.println("Performing Substraction Operation");

        // WebElement searchBar1 =
        // driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
        // searchBar1.sendKeys("calculator");
        // searchBar.submit();
        // Thread.sleep(2000);
        WebElement valueOne = driver.findElement(By.xpath("//div[@class='PaQdxb A2W7l']/div[text()='1']"));
        valueOne.click();
        WebElement valueFive5 = driver.findElement(By.xpath("//div[@class='PaQdxb A2W7l']/div[text()='5']"));
        valueFive5.click();
        WebElement valueMinus = driver.findElement(By.xpath("//div[@class='PaQdxb mF5fo']/div"));
        valueMinus.click();
        WebElement valueEight = driver.findElement(By.xpath("//div[@class='PaQdxb A2W7l']/div[text()='8']"));
        valueEight.click();
        WebElement valueEqualTo = driver.findElement(By.xpath("//div[@class='PaQdxb mF5fo G7BHUb']/div[text()='=']"));
        valueEqualTo.click();
        WebElement result1 = driver.findElement(By.xpath("//div[@jsname='zLiRgc']/span"));
        String actualResult1 = result1.getText();
        String expectedResult1 = "7";

        if (actualResult1.contains(expectedResult1)) {
            System.out.println("Verifying: " + expectedResult1);

        }
        WebElement removeAll1 = driver.findElement(By.xpath("//div[@jsname='SLn8gc']"));
        removeAll1.click();
        Thread.sleep(2000);

        System.out.println("end Test case: testCase02");
    }

}
