package selenium_java_automation_tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Task_3 {

    WebDriver driver;

    public Task_3(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean navigateToGoogleNews(){

        String url = "https://news.google.com/home?hl=en-IN&gl=IN&ceid=IN:en";

        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
        return false;
    }

    @Test
    public void printGoogleNewsIndia(){

        WebElement clickIndia = driver.findElement(By.xpath("//div[@class='EctEBd']//a[text()='India']"));
        clickIndia.click();

        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='IbUd0d']//h1")));

        System.out.println("News From India");

        List<WebElement> sourceChannels = driver.findElements(
                By.xpath("//div[@class='f9uzM']//div[@class='MCAGUe']//div[@class='a7P8l']//div[@class='vr1PYe']"));
        List<WebElement> headlines = driver.findElements(By.xpath("//article[@class='UwIKyb']//a[@class='gPFEn']"));
        List<WebElement> time = driver.findElements(By.xpath("//div[@class='UOVeFe Jjkwtf']//time"));

        for (int i = 0; i < 15 && i < sourceChannels.size() && i < headlines.size() && i < time.size(); i++) {
            String sourceChannelText = sourceChannels.get(i).getText();
            String headlineText = headlines.get(i).getText();
            String timeText = time.get(i).getText();

            if (!sourceChannelText.isEmpty() && !headlineText.isEmpty() && !timeText.isEmpty()) {
                System.out.println("Channel/Newspaper/Article: " + sourceChannelText);
                System.out.println("Headline: " + headlineText);
                System.out.println("Time Posted: " + timeText);
                System.out.println();
            }
        }
    }

    @Test
    public void printGoogleNewsWorld(){

        WebElement worldClick = driver.findElement(By.xpath("//c-wiz[@jsrenderer='xhgKH']//div[@class='EctEBd']//a[text()='World']"));
        worldClick.click();

        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='IbUd0d']//h1")));

        System.out.println("News from World");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//article[@class='UwIKyb']//div[@class='MCAGUe']//div[@class='a7P8l']//div[@class='vr1PYe']")));

        List<WebElement> sourceChannels = driver.findElements(
                By.xpath("//article[@class='UwIKyb']//div[@class='MCAGUe']//div[@class='a7P8l']//div[@class='vr1PYe']"));
        List<WebElement> headlines = driver.findElements(By.xpath("//article[@class='UwIKyb']//a[@class='gPFEn']"));
        List<WebElement> time = driver.findElements(By.xpath("//article[@class='UwIKyb']//div[@class='UOVeFe Jjkwtf']//time"));

        for (int i = 0; i < 15 && i < sourceChannels.size() && i < headlines.size() && i < time.size(); i++) {
            String sourceChannelText = sourceChannels.get(i).getText();
            String headlineText = headlines.get(i).getText();
            String timeText = time.get(i).getText();

            if (!sourceChannelText.isEmpty() && !headlineText.isEmpty() && !timeText.isEmpty()) {
                System.out.println("Channel/Newspaper/Article: " + sourceChannelText);
                System.out.println("Headline: " + headlineText);
                System.out.println("Time Posted: " + timeText);
                System.out.println();
            }
        }
    }
}