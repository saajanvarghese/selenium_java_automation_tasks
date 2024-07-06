package selenium_java_automation_tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @Test
    public void printFoundersList() {

        try {
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchInput']"));
            searchBox.click();

            searchBox.sendKeys("Apple Inc.");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions
                    .presenceOfAllElementsLocatedBy(By.xpath("//div[@class='suggestions-dropdown']//a//div//h3")));

            List<WebElement> searchList = driver
                    .findElements(By.xpath("//div[@class='suggestions-dropdown']//a//div//h3"));

            for (WebElement searchResults : searchList) {
                String searchListText = searchResults.getText();
                if (searchListText.contains("Apple Inc.")) {
                    // Click the element that matches the condition
                    searchResults.click();
                    break;
                }
            }

            List<WebElement> foundersList = driver.findElements(By.xpath("(//div[@class='plainlist'])[4]//ul/li/a"));

            for (WebElement foundersListElement : foundersList) {
                String foundersListText = foundersListElement.getText();

                System.out.println("Founders List: " + foundersListText);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}