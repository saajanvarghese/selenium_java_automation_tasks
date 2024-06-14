package selenium_java_automation_tasks;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_6 {

    WebDriver driver;

    public Task_6(WebDriver driver){
        this.driver = driver;
    }

    public Boolean navigateToFlipkart(){
        String url = "https://www.flipkart.com/";

        if(!driver.getCurrentUrl().equals(url)){
            driver.get(url);
            return true;
        }
        else{
            return false;
        }
    }

    @Test
    public Boolean searchProduct(String productName){
        try {

            WebDriverWait searchBoxwait = new WebDriverWait(driver, Duration.ofSeconds(30));
            searchBoxwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));

            WebElement searchBoxClick = driver.findElement(By.xpath("//input[@name='q']")); 
        searchBoxClick.click();

        searchBoxClick.clear();

        searchBoxClick.sendKeys(productName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='_2iLD__']")));

        WebElement searchClick = driver.findElement(By.xpath("//button[@class='_2iLD__']"));
        searchClick.click();

        WebElement verifyProduct = driver.findElement(By.xpath("//span[@class='BUOuZu']//span"));

        String verifyProductText = verifyProduct.getText();

        Assert.assertEquals(verifyProductText, productName);

        return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }

    @Test
    public int countProducts(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='_75nlfW']")));

            List<WebElement> productList = driver.findElements(By.xpath("//div[@class='_75nlfW']"));

            int productCount = productList.size();

            System.out.println("Product Count : "+productList.size());

            return productCount;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return 0;  //if productCount is 0.
    }   

    @Test
    public void SortBy(String sort) {
        List<WebElement> SortBy = driver.findElements(By.xpath("//div[@class='zg-M3Z']"));

        for (WebElement SortBySelect : SortBy) {
            String sortByText = SortBySelect.getText();
            if (sortByText.contains(sort)) {
                SortBySelect.click();
                break;
            }
        }
    }

    @Test
        public void addProductToCart(){
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='col col-7-12']/child::div[@class='KzDlHZ'])[1]")));

                
                WebElement clickProduct = driver.findElement(By.xpath("(//div[@class='col col-7-12']/child::div[@class='KzDlHZ'])[1]"));
            clickProduct.click();

            String originalWindow = driver.getWindowHandle();

            Set<String> windowHandles = driver.getWindowHandles();

            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            WebElement productCheck = driver.findElement(By.xpath("//span[@class='VU-ZEz']"));
            String productCheckText = productCheck.getText();

            Assert.assertEquals(productCheckText, productCheckText);

            WebElement addToCartbtn = driver.findElement(By.cssSelector(".QqFHMw.vslbG\\+.In9uk2"));
            addToCartbtn.click();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }            
        }
        
        @Test
        public void calculateProductAmount(){

            try {
                String priceText = "";
                String discountText = "";
                String totalAmountText = "";

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='b5rp0W'])[1]")));

                WebElement priceElement = driver.findElement(By.xpath("(//span[@class='b5rp0W'])[1]"));
                String price = priceElement.getText().trim();

                priceText = price.replaceAll("[^0-9,]", "").trim();

                priceText = priceText.replace(",", "");

                WebElement discounElement = driver.findElement(By.xpath("(//span[@class='_6HMXbu'])[1]"));
                String discount = discounElement.getText().trim();

                discountText = discount.replaceAll("[^0-9,]", "").trim();

                discountText = discountText.replace(",", "");

                int priceAmt = Integer.parseInt(priceText);
                int discountAmt = Integer.parseInt(discountText);

                int result = priceAmt - discountAmt;

                WebElement totalAmountElement = driver.findElement(By.xpath("(//div[@class='_1Y9Lgu']//span)[2]"));
                String totalAmount = totalAmountElement.getText();

                totalAmountText = totalAmount.replaceAll("[^0-9,]", "").trim();

                totalAmountText = totalAmountText.replace(",", "");

                int totalAmt = Integer.parseInt(totalAmountText);

                Assert.assertEquals(result, totalAmt);

                System.out.println("Total Amount: "+totalAmt);

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
}