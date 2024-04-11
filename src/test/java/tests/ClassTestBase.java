package tests;
//import jdk.jpackage.internal.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.ClassPageHome;
import pages.ClassPageRegister;
import pages.ClassPageLogin;
import pages.ClassPageOrder;

public class ClassTestBase {
    public WebDriver driver;
    protected   ClassPageHome classPageHome;
    protected   ClassPageRegister classPageRegister;
    protected   ClassPageLogin classPageLogin;
    protected ClassPageOrder classPageOrder;

   @BeforeMethod
    public void  setUp(){
        //Log.info("Instanciando Navegador");
        driver = new ChromeDriver();
        classPageHome = new ClassPageHome(driver);
        classPageRegister = new ClassPageRegister(driver);
        classPageLogin = new ClassPageLogin(driver);
        classPageOrder = new ClassPageOrder(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
