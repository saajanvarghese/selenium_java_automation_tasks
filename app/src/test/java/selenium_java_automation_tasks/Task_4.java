package selenium_java_automation_tasks;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_4 {

      WebDriver driver;

    public Task_4(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean navigateWebPage(){

        String url = "https://jqueryui.com/datepicker/";

        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
        return false;
    }

    @Test
    public void printWeekendsofthemonth(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='demo-frame']")));
        
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);

        WebDriverWait date_picker_wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        date_picker_wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='hasDatepicker']")));

        WebElement date_picker = driver.findElement(By.xpath("//input[@class='hasDatepicker']"));
        date_picker.click();

        List<WebElement> dates = driver.findElements(By.className("ui-datepicker-week-end"));

        int getdates =dates.size()-1;

        for(int i =3; i<=getdates;){

            if(i%2==0){
                WebElement Sunday = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//th[1]"));
                String getSundaytxt = Sunday.getText();
                System.out.println(getSundaytxt+" : "+dates.get(i).getText());  
                i++;
            }
            else if(i%2!=0){
                WebElement Saturday = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//th[7]"));
                String getSaturdaytxt = Saturday.getText();
                System.out.println(getSaturdaytxt+" : "+dates.get(i).getText());
                i++;
            }
            else{
                System.out.println("Invalid Dates");
            }
        }
        driver.switchTo().defaultContent();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }  

    @Test
    public void selectCurrentDate() {
        try {
            WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
            driver.switchTo().frame(iframe);

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");
            DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
            DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");
    
            String day = currentDate.format(dayFormatter);
            String month = currentDate.format(monthFormatter);
            String year = currentDate.format(yearFormatter);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']//span[text()='" + month + "']")));
                
            WebElement monthElement = driver
                    .findElement(By.xpath("//div[@class='ui-datepicker-title']//span[text()='" + month + "']"));
            String monthtext = monthElement.getText();
            Assert.assertEquals(monthtext, month);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']//span[text()='" + year + "']")));
    
            WebElement yearElement = driver
                    .findElement(By.xpath("//div[@class='ui-datepicker-title']//span[text()='" + year + "']"));
            String yearText = yearElement.getText();
            Assert.assertEquals(yearText, year);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@data-handler='selectDay']//a[text()='" + day + "']")));
    
            WebElement dayElement = driver
                    .findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='" + day + "']"));
            String dayText = dayElement.getText();
            Assert.assertEquals(dayText, day);
    
            dayElement.click();
      
            System.out.println("Date: "+day+" "+month+" "+year);

            driver.switchTo().defaultContent();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}