package selenium_java_automation_tasks.Task_8;

import java.time.Duration;
import java.util.ArrayList;
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

public class Task_8 {

    // RAM Specifications
    private String RAMProductName;
    private String RAMCapacity;
    private String RAM_Model;
    private String RAMTechnology;

    // SSD Specifications
    private String SSDProductName;
    private String SSDCapacity;
    private String SSDModel;

    WebDriver driver;

    public Task_8(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToAmazon() {
        String url = "https://www.amazon.in/";

        if (driver.getCurrentUrl() != url) {
            driver.get(url);
        }
    }

    public void navigateToGoogle() {
        String url = "https://www.google.com/";

        if (driver.getCurrentUrl() != url) {
            driver.get(url);
        }
    }

    @Test(enabled = true)
    public void searchCrucialRAM_in_Google(String productName) {

        try {
            WebElement googleSearchtxtBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
            SeleniumWrapper.enterText(googleSearchtxtBox, productName);

            WebElement search_result_click = driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[2]"));
            search_result_click.click();

            // Reject cookies in crucial webpage

            Thread.sleep(5000);

            WebElement rejectCookies = driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']"));
            rejectCookies.click();

            System.out.println("*********************CRUCIAL RAM SPECIFICATION AND VERIFICATION***********************");

            WebElement productTitle = driver.findElement(By.xpath("//h1[@class='product-title']"));
            RAMProductName = productTitle.getText();
            if (productTitle.getText().equals(productName)) {
                System.out.println(productName + " : Product Name Verifed");
            } else {
                System.out.println("Product Name not verified");
            }

            WebElement ProductModel = driver
                    .findElement(By.xpath("(//span[@class='h2 part-number base-part-number'])[2]"));
            RAM_Model = ProductModel.getText();

            if (ProductModel.getText().equals(RAM_Model)) {
                System.out.println("RAM Model : Verified");
            } else {
                System.out.println("RAM Model not verified");
            }

            WebElement ddr4Check = driver.findElement(By.xpath("(//td[@class='spec-value'])[2]"));
            RAMTechnology = ddr4Check.getText();
            if (ddr4Check.getText().equals("DDR4")) {
                System.out.println("RAM is DDR4 Type : Verified");
            } else {
                System.out.println("RAM Does not contain DDR Type");
            }

            WebElement RAM_Capacity = driver.findElement(By.xpath("(//td[@class='spec-value'])[3]"));
            RAMCapacity = RAM_Capacity.getText();
            if (RAM_Capacity.getText().trim().equals("16GB")) {
                System.out.println("RAM = 16GB : Verified");
            } else {
                System.out.println("RAM Does not have Capacity");
            }

            WebElement ModuleType = driver.findElement(By.xpath("(//td[@class='spec-value'])[6]"));
            if (ModuleType.getText().equals("SODIMM")) {
                System.out.println("Module Type : SODIMM : Verified");
            } else {
                System.out.println("RAM does not have a Module Type");
            }

            WebElement warranty = driver.findElement(By.xpath("(//td[@class='spec-value'])[9]"));
            if (warranty.getText().equals("Limited Lifetime")) {
                System.out.println("RAM has Limited Warranty : Verified");
            } else {
                System.out.println("RAM does not have Warranty");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test(enabled = true)
    public void search_Western_Digital_SSD_Drive_in_Google(String productName) {
        try {
            // Cast the WebDriver to JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Open a new tab
            js.executeScript("window.open();");

            // Switch to the new tab
            // The windowHandles will have two entries after opening a new tab
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); // Switches to the new tab

            // Now you can load a different URL in the new tab
            driver.get("https://www.google.com");

            WebElement googleSearchtxtBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
            SeleniumWrapper.enterText(googleSearchtxtBox, productName);

            WebElement google_search_results_click = driver
                    .findElement(By.xpath("(//a[@jsname='UWckNb'])[2]"));
            google_search_results_click.click();

            System.out.println("********************WD SSD 1TB SPECIFICATION AND VERIFICATION***********************");

            WebElement verifyTitle = driver.findElement(By.xpath("//h1[@class='inline font-bold pdp-product-title']"));
            String SSDProduct_Name = verifyTitle.getText();
            SSDProductName = SSDProduct_Name;
            System.out.println("Product Title : " + verifyTitle.getText());

            WebElement verifyCapacity = driver
                    .findElement(By.xpath("//button[@aria-label=',Capacity Selected: ,1TB']"));
            SSDCapacity = verifyCapacity.getText();
            if (verifyCapacity.getText().equals(SSDCapacity)) {
                System.out.println("SSD Capacity = 1TB : Verified");
            } else {
                System.out.println("Product SSD Capacity not Verified");
            }

            WebElement SSDModelNo = driver.findElement(By.xpath("//span[@class='text-skeleton']"));
            SSDModel = SSDModelNo.getText();
            if (SSDModelNo.getText().equals(SSDModel)) {
                System.out.println("WD SSD Model Number : Verified");
            } else {
                System.out.println("WD SSD Model Number not verified");
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    @Test(enabled = true)
    public void searchinAmazon(String RAM, String SSD) {
        try {
            // Cast the WebDriver to JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Open a new tab
            js.executeScript("window.open();");

            // Switch to the new tab
            // The windowHandles will have two entries after opening a new tab
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2)); // Switches to the new tab

            driver.get("https://www.amazon.in/");

            System.out.println("******************CHECK FOR PRODUCTS IN AMAZON******************************");

            System.out.println("******************CHECK FOR CRUCIAL RAM IN AMAZON***************************");

            WebElement amazonSearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            SeleniumWrapper.enterText(amazonSearchBox, SSD);

            List<WebElement> amazonSearchList = driver
                    .findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

            for (int i = 0; i < amazonSearchList.size(); i++) {
                String amazonResultText = amazonSearchList.get(i).getText();
                if (amazonResultText.contains(RAM)) {
                    amazonSearchList.get(i).click();
                    break;
                }
            }

            // Get all window handles
            Set<String> allTabs = driver.getWindowHandles();

            // Convert the Set to a List to access tabs by index
            List<String> tabsList = new ArrayList<>(allTabs);

            // Switch to the 4th tab (index 3, since it's 0-based)
            driver.switchTo().window(tabsList.get(3));

            WebElement verifyRAM_Model = driver
                    .findElement(By.xpath("(//td[@class='a-size-base prodDetAttrValue'])[3]"));

            if (verifyRAM_Model.getText().equals(RAM_Model)) {
                System.out.println("RAM Model : Verified");
            } else {
                System.out.println("RAM Model not verified");
            }

            WebElement verifyRAM_Capacity = driver
                    .findElement(By.xpath("(//td[@class='a-size-base prodDetAttrValue'])[9]"));

                    String Ram_Size = verifyRAM_Capacity.getText();

                    String Ram_Capacity = Ram_Size.replaceAll("\\s", "");

            if (Ram_Capacity.equals(RAMCapacity)) {
                System.out.println("RAM Capacity : Verified");
            } else {
                System.out.println("RAM Capacity not verified");
            }

            WebElement ProductTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));

            RAMProductName = RAM;

            if(ProductTitle.getText().contains(RAMProductName)){
                System.out.println("RAM ProductName : Verified");
            } else {
                System.out.println("RAM ProductName not verified");
            }

            WebElement RAM_Type = driver.findElement(By.xpath("(//td[@class='a-size-base prodDetAttrValue'])[11]"));

            if(RAM_Type.getText().equals(RAMTechnology)){
                System.out.println("RAM Technology Type : Verified");
            } else {
                System.out.println("RAM Technology Type not verified");
            }


            WebElement RAMaddtocart =  driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));

            RAMaddtocart.click();

            System.out.println("******************CHECK FOR WD GREEN SSD IN AMAZON***************************");

            WebElement amazonSearchBox2 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
           SeleniumWrapper.enterText(amazonSearchBox2, SSD);

            List<WebElement> amazonSearchList2 = driver
            .findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
    
    for (int i = 0; i < amazonSearchList2.size(); i++) {
        String amazonResultText = amazonSearchList2.get(i).getText();
    
        // Check if the text is not null and contains the desired string
        if (amazonResultText != null && amazonResultText.contains(SSD)) {
            amazonSearchList2.get(i).click();
            break; // Exit the loop once the item is found and clicked
        }
    }
    // Get all window handles
    Set<String> allTabs2 = driver.getWindowHandles();

    // Convert the Set to a List to access tabs by index
    List<String> tabsList2 = new ArrayList<>(allTabs2);

    // Switch to the 4th tab (index 3, since it's 0-based)
    driver.switchTo().window(tabsList2.get(4));

    WebElement SSD_Capacity = driver.findElement(By.xpath("(//td[@class='a-size-base prodDetAttrValue'])[10]"));

    String ssd_capacity = SSD_Capacity.getText();

    String SSD_Size = ssd_capacity.replaceAll("\\s", "");

    if (SSD_Size.equals(SSDCapacity)) {
        System.out.println("SSD Capacity : Verified");
    } else {
        System.out.println("SSD Capacity not verified");
    }

    WebElement SSD_Model = driver.findElement(By.xpath("(//td[@class='a-size-base prodDetAttrValue'])[9]"));

    if(SSD_Model.getText().equals(SSDModel)){
        System.out.println("SSD Model : Verified");
    } else {
        System.out.println("SSD Model not verified");
    }

    WebElement SSD_add_to_cart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
    SSD_add_to_cart.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(By.id("attach-close_sideSheet-link")));

    WebElement close_add_to_cart_btn = driver.findElement(By.id("attach-close_sideSheet-link"));
    close_add_to_cart_btn.click();

    Thread.sleep(2000);

    WebElement Viewcart = driver.findElement(By.xpath("//a[@id='nav-cart']"));
    Viewcart.click();

    System.out.println("******************CHECK FOR CARTN CONTENTS IN AMAZON***************************");

    boolean isRAMPresent = false;
    boolean isSSDPresent = false;

    List<WebElement> Cart_Contents = driver.findElements(By.xpath("//span[@class='a-truncate-cut']"));

   
    for (WebElement item : Cart_Contents) {
        String itemText = item.getText();
        System.out.println("Cart Item: " + itemText);

        // Using assert statements
        if (itemText.equals(RAM)) {
            isRAMPresent = true;
            assert itemText.equals(RAM) : "Expected RAM but found something else!";
        }
        if (itemText.equals(SSD)) {
            isSSDPresent = true;
            assert itemText.equals(SSD) : "Expected SSD but found something else!";
        }
    }

    // Final verification using assert
    assert isRAMPresent : "RAM is not present in the cart!";
    assert isSSDPresent : "SSD is not present in the cart!";

    if (isRAMPresent && isSSDPresent) {
        System.out.println("Cart Contents Verified");
    } else {
        System.out.println("Cart Contents not Verified");
    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}