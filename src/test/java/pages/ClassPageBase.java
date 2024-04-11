package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;

import java.time.Duration;
import java.util.List;

public class ClassPageBase {
    WebDriver driver;
    WebDriverWait wait;
    public ClassPageBase(WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
    }
    public void visit (String url) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Variables.TIME_OUT));
        driver.get(url);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
   /* public String getText(WebElement element){
        return element.getText();
    }*/
    public void clear (By locator)  {
        driver.findElement(locator).clear();
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }
    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void click(By locator){
            driver.findElement(locator).click();
    }
    public void submit(By locator){
        driver.findElement(locator).submit();
    }

    public void windowInFrame(By element){
        driver.switchTo().frame(findElement(element));
    }

    public void windowOutFrame(){
        driver.switchTo().defaultContent();
    }

    public Boolean isDisplayed (By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }



}