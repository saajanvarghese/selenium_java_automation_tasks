package selenium_java_automation_tasks.Task_9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_9 {

    WebDriver driver;

     public Task_9(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLink() {
        String url = "https://www.cricbuzz.com/";

        if (driver.getCurrentUrl() != url) {
            driver.get(url);
        }
    }

    @Test(enabled = true)
    public void printPlayersofSixersInCricketMatch() {

  try {
        driver.get("https://www.cricbuzz.com/");

        // Assert that page title contains "Cricbuzz"
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Cricbuzz"), "Page title does not contain 'Cricbuzz'.");

        WebElement live_score_click = driver.findElement(By.xpath("//nav[@id='cb-main-menu']//a[@title='Live Cricket Score']"));
        live_score_click.click();

        WebElement scorecard_click = driver.findElement(By.xpath("(//a[@title='Scorecard'])[1]"));
        scorecard_click.click();

        WebElement match_info = driver.findElement(By.xpath("//h1[@class='cb-nav-hdr cb-font-18 line-ht24']"));
        String match_info_text = match_info.getText();

        System.out.println(match_info_text);

        // Assert that match info text is not empty
        Assert.assertFalse(match_info_text.trim().isEmpty(), "Match info text is empty.");

        List<WebElement> batter_list = driver.findElements(By.xpath("//div[@class='cb-col cb-col-25 ']//a[@class='cb-text-link']"));
        List<WebElement> sixer_list = driver.findElements(By.xpath("//div[@class='cb-col cb-col-8\ttext-right']"));

        // Assert that both lists have same size
        Assert.assertEquals(batter_list.size(), sixer_list.size(), "Batter list and sixer list sizes do not match.");

        for (int i = 0; i < batter_list.size(); i++) {
            WebElement batter = batter_list.get(i);
            String batter_text = batter.getText().trim();

            WebElement sixer_info = sixer_list.get(i);
            String sixer_info_text = sixer_info.getText().trim();

            // Assert that batter name is not empty
            Assert.assertFalse(batter_text.isEmpty(), "Batter name is empty at index: " + i);

            // Assert that sixer info is a number and not empty
            Assert.assertFalse(sixer_info_text.isEmpty(), "Sixer info is empty for batter: " + batter_text);
            try {
                int sixCount = Integer.parseInt(sixer_info_text);
                Assert.assertTrue(sixCount >= 0, "Sixer count is negative for batter: " + batter_text);
            } catch (NumberFormatException e) {
                Assert.fail("Sixer info is not a valid number for batter: " + batter_text);
            }

            System.out.println("Batter " + batter_text + "     6s " + sixer_info_text);
        }

        driver.quit();
    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("Test failed due to exception: " + e.getMessage());
    }
}
}
