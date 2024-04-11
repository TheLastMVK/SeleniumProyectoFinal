package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ClassPageLogin extends ClassPageBase {
    By LblLoginAccount = By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div/h1");
    By LblForgotPassword = By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div/div/a[2]");
    By TxtMail = By.name("email");
    By TxtPass = By.name("password");
    By BtnLogin = By.className("button");
    By BtnReset = By.className("form-submit-button");

    public ClassPageLogin(WebDriver driver) {
        super(driver);
    }
    public void loginUser() throws InterruptedException {
        if(isDisplayed(LblLoginAccount)){
            type("ing.jorgecisneroscab90@gmail.com",TxtMail);
            type(Variables.password,TxtPass);
            click(BtnLogin);
        }else  {
            System.out.println("Login page was not found");
        }
    }
    public void loginUserPassIncorrect() throws InterruptedException {
        if(isDisplayed(LblLoginAccount)){
            type("ing.jorgecisneroscab90@gmail.com",TxtMail);
            type("asdfgfghdf",TxtPass);
            click(BtnLogin);
        }else  {
            System.out.println("Login page was not found");
        }
    }
    public void loginUserWithFieldEmpty() throws InterruptedException {
        if(isDisplayed(LblLoginAccount)){
            click(BtnLogin);
        }else  {
            System.out.println("Login page was not found");
        }
    }

    public void loginUserWithMailIncorrect() throws InterruptedException {
        if(isDisplayed(LblLoginAccount)){
            type("ing.jorgecisneroscab99999@gmail.com",TxtMail);
            type(Variables.password,TxtPass);
            click(BtnLogin);
        }else  {
            System.out.println("Login page was not found");
        }
    }

    public void loginUserPassForget() throws InterruptedException {
        if(isDisplayed(LblLoginAccount)){
            click(LblForgotPassword);

            wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
            wait.until(ExpectedConditions.presenceOfElementLocated(BtnReset));
            type("ing.jorgecisneroscab@gmail.com", TxtMail);
            click(BtnReset);

        }else  {
            System.out.println("Login page was not found");
        }
    }

    public String isPageLoginDisplayed() {
        return driver.getTitle();
    }

}