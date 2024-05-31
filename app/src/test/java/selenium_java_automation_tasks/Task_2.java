package selenium_java_automation_tasks;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_2 {
     WebDriver driver;

    public Task_2(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean navigateToAmazonPage(){

        String url = "https://www.amazon.in/";

        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
        return false;
    }

       @Test
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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-color-state a-text-bold']")));

        WebElement verifyAmazonResultPage = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

        Assert.assertTrue(verifyAmazonResultPage.isDisplayed(),
                "Failed: Searched Keyword is not present in Amazon result page");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Test
    public void product_search_using_contains() throws InterruptedException {

        try {
            List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        int count =0;

        for(int i=0; i<list.size(); i++){

            String item_name = list.get(i).getText();
            if(item_name.contains("128")){
                count++;
                Assert.assertFalse(item_name.isEmpty(), "Product title is empty");
                System.out.println(item_name);
            }
        }
        System.out.println("Total Count : "+count);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}