package pages;

import utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ClassPageRegister extends ClassPageBase {
    By BtnSingIn = By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div[3]/a");
    By LblCreateAccount = By.xpath("//*[@id=\"app\"]/div/main/div[1]/span[2]");
    By BtnSignup = By.className("form-submit-button");
    By TxtName = By.name("full_name");
    By TxtMail = By.name("email");
    By TxtPass = By.name("password");

    public ClassPageRegister(WebDriver driver) {
        super(driver);
    }
    public void registerUser() {
        if(isDisplayed(LblCreateAccount)){
            type(Variables.names,TxtName);
            type(Variables.mail,TxtMail);
            type(Variables.password,TxtPass);
            click(BtnSignup);
        }else  {
            System.out.println("Register page was not found");
        }
    }
    public void registerWithoutfields() {
        if(isDisplayed(LblCreateAccount)){
            type(Variables.mail,TxtMail);
            type(Variables.password,TxtPass);
            click(BtnSignup);
        }else  {
            System.out.println("Register page was not found");
        }
    }

    public void registerWithIncorrectFormat() {
        if(isDisplayed(LblCreateAccount)){
            type(Variables.names,TxtName);
            type("JorgeCisneros@abc",TxtMail);
            type(Variables.password,TxtPass);
            click(BtnSignup);
        }else  {
            System.out.println("Register page was not found");
        }
    }

    public void registerWithIncorrectPass() {
        if(isDisplayed(LblCreateAccount)){
            type(Variables.names,TxtName);
            type(Variables.mail,TxtMail);
            click(BtnSignup);
        }else  {
            System.out.println("Register page was not found");
        }
    }

    public void registerWithPassConfirmed() {
        if(isDisplayed(LblCreateAccount)){
            type(Variables.names,TxtName);
            type(Variables.mail,TxtMail);
            type(Variables.password,TxtPass);
            click(BtnSignup);
         }else  {
            System.out.println("Register page was not found");
        }
    }
    public void registerWithMailRepeated() {
        if(isDisplayed(LblCreateAccount)){
            type(Variables.names,TxtName);
            type("ing.jorgecisneroscab90",TxtMail);
            type(Variables.password,TxtPass);
            click(BtnSignup);
        }else  {
            System.out.println("Register page was not found");
        }
    }
    public void goToSingIn(){
        click(BtnSingIn);
    }
    public String isPageRegisterDisplayed() {
             return driver.getTitle();
    }


}