package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Variables;
import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class ClassTestRegister extends ClassTestBase {
    public WebDriverWait wait;

    @Test (priority = 1, testName = "TC-Register-01", groups = {"functional"})
    public void registerNewAccountWithRequiredData() {
        setUp();
        classPageHome.goToSingIn();
        classPageHome.goToRegisterOption();
        assertEquals("Create an account", classPageHome.isPageLoginDisplayed());
        System.out.println("El titulo pagina de creacion estimada es 'Create an account', Titulo pagina obtenida es: "+  classPageHome.isPageLoginDisplayed());

        classPageRegister.registerUser();

        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        WebElement imgProduct = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div[1]/div[1]/img")));
        assertTrue(imgProduct.getAttribute("src").toString().contains("/assets/homepage/banner/men-shoes.jpeg"));

        classPageRegister.goToSingIn();
        assertEquals("Account details", classPageRegister.isPageRegisterDisplayed());
        System.out.println("El titulo pagina de cuenta estimada es 'Account details', Titulo pagina obtenida es: "+  classPageHome.isPageLoginDisplayed() );
    }

    @Test (priority = 2, testName = "TC-Register-02", groups = {"functional", "integration"})
    public void registerNewAccountWithoutRequiredData() {
        setUp();
        classPageHome.goToSingIn();
        classPageHome.goToRegisterOption();
        assertEquals("Create an account", classPageHome.isPageLoginDisplayed());
        System.out.println("El titulo pagina de creacion estimada es 'Create an account', Titulo pagina obtenida es: "+  classPageHome.isPageLoginDisplayed());

        classPageRegister.registerWithoutfields();

        String txtError = classPageHome.getText(By.xpath("//*[@id=\"registerForm\"]/div[1]/div[2]/span"));
        assertEquals("This field can not be empty", txtError );
        System.out.println("El mensaje de validacion estimada es 'This field can not be empty', mensaje real obtenido es: "+ txtError);
    }

    @Test (priority = 3, testName = "TC-Register-03", groups = {"functional","regression"})
    public void registerNewAccountWithIncorrectFormat() {
        setUp();
        classPageHome.goToSingIn();
        classPageHome.goToRegisterOption();
        assertEquals("Create an account", classPageHome.isPageLoginDisplayed());
        System.out.println("El titulo pagina de creacion estimada es 'Create an account', Titulo pagina obtenida es: "+  classPageHome.isPageLoginDisplayed());

        classPageRegister.registerWithIncorrectFormat();

        String txtError = classPageHome.getText(By.xpath("//*[@id=\"registerForm\"]/div[2]/div[2]/span"));
        assertEquals("Invalid email", txtError );
        System.out.println("El mensaje de validacion estimada es 'Invalid email', mensaje real obtenido es: "+ txtError);
    }


    @Test (priority = 4, testName = "TC-Register-04", groups = {"regression"})
    public void registerNewAccountWithIncorrectPass() {
        setUp();
        classPageHome.goToSingIn();
        classPageHome.goToRegisterOption();
        assertEquals("Create an account", classPageHome.isPageLoginDisplayed());
        System.out.println("El titulo pagina de creacion estimada es 'Create an account', Titulo pagina obtenida es: "+  classPageHome.isPageLoginDisplayed());

        classPageRegister.registerWithIncorrectPass();

        String txtError = classPageHome.getText(By.xpath("//*[@id=\"registerForm\"]/div[3]/div[2]/span"));
        assertEquals("This field can not be empty", txtError );
        System.out.println("El mensaje de validacion estimada es 'This field can not be empty', mensaje real obtenido es: "+ txtError);
    }

    @Test (priority = 5, testName = "TC-Register-05", groups = {"functional", "integration"})
    public void registerNewAccountWithPassConfirmed() {
        setUp();
        classPageHome.goToSingIn();
        classPageHome.goToRegisterOption();
        assertEquals("Create an account", classPageHome.isPageLoginDisplayed());
        System.out.println("El titulo pagina de creacion estimada es 'Create an account', Titulo pagina obtenida es: "+  classPageHome.isPageLoginDisplayed());

        classPageRegister.registerWithPassConfirmed();

        assertEquals("JorDanCis123", Variables.password );
        System.out.println("El password ingresado para el registro es 'JorDanCis123', se confirma el password obtenido: "+ Variables.password);
    }

    @Test (priority = 6, testName = "TC-Register-06", groups = {"integration"})
    public void registerNewAccountWithMailRepeated() {
        setUp();
        classPageHome.goToSingIn();
        classPageHome.goToRegisterOption();
        assertEquals("Create an account", classPageHome.isPageLoginDisplayed());
        System.out.println("El titulo pagina de creacion estimada es 'Create an account', Titulo pagina obtenida es: "+  classPageHome.isPageLoginDisplayed());

        classPageRegister.registerWithMailRepeated();

        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        WebElement msgError = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("text-critical")));

        if(msgError.getText().equals("Invalid email")){

            System.out.println("El correo ingresado: "+ msgError.getText() + " ya se encuentra registrada por otro usuario");

        }else  {
            System.out.println("Sentencia incorrecta");
        }
    }





}