package selenium_java_automation_tasks.Task_5;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SeleniumWrapper {

    public static void enterText(WebElement inputBox, String keysToSend){

        try {
            inputBox.click();
            inputBox.clear();
            inputBox.sendKeys(keysToSend);
            inputBox.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    
}
