package selenium_java_automation_tasks.Task_1;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_1 {
    WebDriver driver;

    public Task_1(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean navigateToAmazonPage() {

        String url = "https://www.amazon.in/";

        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
        return false;
    }

    @Test(enabled = true)
    public void amazonSearch(String product) {

        try {
            WebElement amazonSearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

            Assert.assertTrue(amazonSearchBox.isDisplayed(), "Failed: Amazon Search Box is not Present");

            amazonSearchBox.click();

            amazonSearchBox.sendKeys(product);

            WebElement amazonSearchbtn = driver.findElement(By.id("nav-search-submit-button"));
            amazonSearchbtn.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(
                    ExpectedConditions
                            .visibilityOfElementLocated(By.xpath("//span[@class='a-color-state a-text-bold']")));

            WebElement verifyAmazonResultPage = driver
                    .findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

            Assert.assertTrue(verifyAmazonResultPage.isDisplayed(),
                    "Failed: Searched Keyword is not present in Amazon result page");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @Test(enabled = true)
    public void listProductTitles() throws InterruptedException {

        try {
            List<WebElement> list = driver
                    .findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

            for (int i = 0; i < 5 && i < list.size(); i++) { // to print first 5 Product Titles
                String listitem = list.get(i).getText();
                Assert.assertFalse(listitem.isEmpty(), "Product title is empty");
                System.out.println("Product Title :" + listitem);
            }

            driver.quit();
        } catch (Exception e) {
            // TODO: handle exception
           e.printStackTrace();
        Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}