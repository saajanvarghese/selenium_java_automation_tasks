package selenium_java_automation_tasks.Task_7;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_7 {
    WebDriver driver;

    public Task_7(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAmazon() {
        String url = "https://www.amazon.in/";

        if (driver.getCurrentUrl() != url) {
            driver.get(url);
        }
    }

    @Test
    public void searchProduct(String productName) {

        try {
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            searchBox.click();
            searchBox.clear();
            searchBox.sendKeys(productName);

            WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
            searchBtn.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']//span")));

            List<WebElement> searchResults = driver.findElements(By.xpath(
                    "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']//span"));

            for (int i = 0; i < searchResults.size(); i++) {
                WebElement result = searchResults.get(i);
                String product = result.getText();
                if (product.contains(productName)) {
                    // Scroll the element into view
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", result);

                    // Wait until the element is clickable
                    wait.until(ExpectedConditions.elementToBeClickable(result));

                    // Click using JavaScript
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", result);
                    break;
                }
            }

            String originalWindow = driver.getWindowHandle();

            Set<String> windowHandles = driver.getWindowHandles();

            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // Wait for the product page to load
            wait.until(ExpectedConditions.titleContains(productName));

            WebElement productTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
            String productTitleText = productTitle.getText().trim();

            System.out.println(productTitleText);

            Assert.assertEquals(productName, productTitleText);

            try {
                WebDriverWait product = new WebDriverWait(driver, Duration.ofSeconds(10));
                product.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "(//div[@class='a-cardui _p13n-desktop-sims-fbt_fbt-desktop_new-detail-faceout-box___WyNy'])[2]")));
                WebElement product2 = driver.findElement(By.xpath(
                        "(//div[@class='a-cardui _p13n-desktop-sims-fbt_fbt-desktop_new-detail-faceout-box___WyNy'])[2]"));

                if (product2.isDisplayed()) {
                    WebElement AddtoCart = driver.findElement(By.xpath("(//input[@name='submit.addToCart'])[1]"));
                    AddtoCart.click();
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            try {
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
                WebElement AddtoCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
                AddtoCart.click();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            try {
                WebDriverWait wait_1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait_1.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")));
                WebElement AddToCart = driver.findElement(
                        By.xpath("//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']"));
                String addToCartText = AddToCart.getText();
                if (addToCartText.contains("Added to Cart")) {
                    driver.close();
                    driver.switchTo().window(originalWindow);
                } else {
                    driver.close();
                    driver.switchTo().window(originalWindow);
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public Boolean CalculateTotalAmount() {
        try {
            WebElement ProceedToCheckout = driver.findElement(By.xpath("//a[@id='nav-cart']"));
            ProceedToCheckout.click();

            List<WebElement> CartProducts = driver.findElements(By.xpath("//span[@class='a-truncate-cut']"));
            for (int i = 0; i < CartProducts.size(); i++) {
                WebElement product = CartProducts.get(i);
                String productText = product.getText();
  
                if (productText.contains("Samsung Galaxy S23 Ultra 5G (Green, 12GB, 256GB Storage)")) {
                    WebElement deleteBtn = driver.findElement(By.xpath(
                            "//input[@aria-label='Delete Samsung Galaxy S23 Ultra 5G (Green, 12GB, 256GB Storage)']"));
                    deleteBtn.click();
                    break;
                }
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")));

            WebElement productPrice_1 = driver.findElement(By.xpath(
                    "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]"));
            String price_1 = productPrice_1.getText();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[2]")));

            WebElement productPrice_2 = driver.findElement(By.xpath(
                    "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[2]"));
            String price_2 = productPrice_2.getText();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[3]")));

            WebElement productPrice_3 = driver.findElement(By.xpath(
                    "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[3]"));
            String price_3 = productPrice_3.getText();

            String price_1Text = price_1.replaceAll("[^0-9,]", "").trim();

            price_1Text = price_1Text.replace(",", "");

            String price_2Text = price_2.replaceAll("[^0-9,]", "").trim();

            price_2Text = price_2Text.replace(",", "");

            String price_3Text = price_3.replaceAll("[^0-9,]", "").trim();

            price_3Text = price_3Text.replace(",", "");

            int cartProductPrice_1 = Integer.parseInt(price_1Text);
            int cartProductPrice_2 = Integer.parseInt(price_2Text);
            int cartProductPrice_3 = Integer.parseInt(price_3Text);

            int totalAmount = cartProductPrice_1 + cartProductPrice_2 + cartProductPrice_3;

            WebElement totalAmountElement = driver.findElement(
                    By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]"));
            String totalAmountText = totalAmountElement.getText();

            String totalAmounString = totalAmountText.replaceAll("[^0-9,]", "");

            totalAmounString = totalAmounString.replace(",", "");

            int cartTotalAmount = Integer.parseInt(totalAmounString);

            Assert.assertEquals(totalAmount, cartTotalAmount);

            return true;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
}