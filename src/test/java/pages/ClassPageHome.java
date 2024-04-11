package pages;

import utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassPageHome extends ClassPageBase {
    By BtnSingIn = By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div[3]/a");
    By linkAccount = By.linkText("Create an account");


     public ClassPageHome(WebDriver driver){
        super(driver);
        visit(Variables.BASE_URL);
    }
    public void goToSingIn(){
        click(BtnSingIn);
    }
    public void goToRegisterOption(){
        click(linkAccount);
    }
    public String isPageLoginDisplayed() {
        return driver.getTitle();
    }
}