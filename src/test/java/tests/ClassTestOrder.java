package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Variables;

import static org.testng.AssertJUnit.assertEquals;

public class ClassTestOrder extends ClassTestBase{

    public WebDriverWait wait;

    @Test (priority = 1, testName = "TC-Order-01", groups = {"regression"})
    public void test() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUser();
        classPageOrder.productMen();
        String txtAlert = classPageOrder.getText(By.xpath("/html/body/div/div/div[4]/div/div/div/div/div/div[1]/div[1]"));
        assertEquals("JUST ADDED TO YOUR CART", txtAlert );
        System.out.println("Se confirma la agregación del producto al carrito de compras");
    }


    @Test (priority = 2, testName = "TC-Order-02", groups = {"regression"})
    public void DeleteProduct() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUser();
        classPageOrder.productDeleted();
        String txtAlert = classPageOrder.getText(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div[2]/span"));
        assertEquals("Your cart is empty!", txtAlert );
        System.out.println("Se confirma la anulacion de la compra en el carrito");
    }

    @Test (priority = 3, testName = "TC-Order-03", groups = {"functional", "integration"})
    public void EditCantProduct() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUser();
        classPageOrder.productMen();
        classPageHome.visit(Variables.BASE_URL);
        classPageOrder.productEdited();
        String txtAlert = classPageOrder.getText(By.xpath("/html/body/div/div/div[4]/div/div/div/div/div/div[1]/div[1]"));
        assertEquals("JUST ADDED TO YOUR CART", txtAlert );
        System.out.println("Se confirma la actualizacion de la cantidad del producto al carrito de compras");
    }

    @Test (priority = 4, testName = "TC-Order-04", groups = {"regression"})
    public void OrdenarProducto() throws InterruptedException{
        setUp();
        classPageHome.goToSingIn();
        classPageLogin.loginUser();
        classPageOrder.productMen();
        classPageOrder.productMen2();
        classPageOrder.productMen3();
        classPageOrder.payProducts();
        String txtAlert = classPageOrder.getText(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div[1]/div/h3/div[2]/div"));
        assertEquals("Thank you Jorge Daniel Cisneros Cabello!", txtAlert );
        System.out.println("FELICIDADES SE FINALIZÓ TODO EL PROCESO DE COMPRA");
    }

}
