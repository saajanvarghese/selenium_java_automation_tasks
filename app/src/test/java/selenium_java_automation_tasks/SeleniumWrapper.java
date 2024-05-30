package selenium_java_automation_tasks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWrapper {

      public static boolean enterText(WebElement inputBox, String keysToSend){
        try{
            inputBox.clear();
            inputBox.sendKeys(keysToSend);
            Thread.sleep(1000);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static boolean clickAction(WebElement element, WebDriver driver){
        if(element.isDisplayed()){
            try {
                JavascriptExecutor js=(JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true)", element);
                element.click();
                Thread.sleep(2000);
                return true;
            } catch (Exception e) {
                // TODO: handle exception
                return false;
            }
        }
        return false;
    }
    
}
