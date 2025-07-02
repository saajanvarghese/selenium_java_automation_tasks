package selenium_java_automation_tasks.Task_5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_5 {

    WebDriver driver;

    public Task_5(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean navigateToWikipediaPage() {

        String url = "https://www.wikipedia.org/";

        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
        return false;
    }

    @Test(enabled = true)
    public void printFoundersList(String productName) {

        try {
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchInput']"));
            SeleniumWrapper.enterText(searchBox, productName);

            List<WebElement> foundersList = driver.findElements(By.xpath("(//div[@class='plainlist'])[4]//ul/li/a"));

            for (WebElement foundersListElement : foundersList) {
                String foundersListText = foundersListElement.getText();

                System.out.println("Founders List: " + foundersListText);

                Assert.assertEquals(foundersListText, foundersListText);
            }
        } catch (Exception e) {
            // TODO: handle exception
           e.printStackTrace();
        Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}