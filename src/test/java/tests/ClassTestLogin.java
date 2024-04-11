package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ClassPageHome;
import pages.ClassPageLogin;
import pages.ClassPageBase;
import pages.ClassPageOrder;
import utils.Variables;
import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ClassTestLogin extends ClassTestBase {

    public WebDriverWait wait;

    @Test (priority = 1, testName = "TC-Login-01", groups = {"regression","integration"})
    public void loginAccountWithUserCorrect() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUser();
        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        WebElement imgProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div[1]/div[1]/img")));
        assertTrue(imgProduct.getAttribute("src").toString().contains("/assets/homepage/banner/men-shoes.jpeg"));

        classPageHome.goToSingIn();

        String lblCorreo = classPageHome.getText(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]"));

        assertEquals("ing.jorgecisneroscab90@gmail.com", lblCorreo);
        System.out.println("El correo estimado es 'ing.jorgecisneroscab90@gmail.com', el correo real obtenido es: "+ lblCorreo);
    }


    @Test (priority = 2, testName = "TC-Login-02", groups = {"functional"})
    public void loginAccountWithUserIncorrect() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUserPassIncorrect();

        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        WebElement msgError = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-critical")));

        if(msgError.getText().equals("Invalid email or password")){
            System.out.println("El Sistema verifica que el password ingresado no es el correcto");
        }else  {
            System.out.println("Sentencia incorrecta");
        }
    }

    @Test (priority = 3, testName = "TC-Login-03", groups = {"functional"})
    public void loginAccountWithUserEmpty() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUserWithFieldEmpty();

        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        WebElement msgError = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-critical")));

        if(msgError.getText().equals("This field can not be empty")){
            System.out.println("El Sistema verifica que el usuario intenta iniciar sesion con campos vacios");
        }else  {
            System.out.println("Sentencia incorrecta");
        }
    }

    @Test (priority = 4, testName = "TC-Login-04", groups = {"regression"})
    public void loginAccountWithMailIncorrect() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUserWithMailIncorrect();

        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        WebElement msgError = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-critical")));

        if(msgError.getText().equals("Invalid email or password")){
            System.out.println("El Sistema verifica que el correo ingresado no esta registrado en la base de datos");
        }else  {
            System.out.println("Sentencia incorrecta");
        }
    }

    @Test (priority = 5, testName = "TC-Login-05", groups = {"functional","integration"})
    public void loginAccountWithPasswordForget() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUserPassForget();

        String msgSend = classPageHome.getText(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div/p"));
        assertEquals("We have sent you an email with a link to reset your password. Please check your inbox.", msgSend);
        System.out.println("El sistema ha enviado correo para el reseteo de su password");
    }

}