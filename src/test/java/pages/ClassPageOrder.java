package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class ClassPageOrder extends ClassPageBase {
    By GetProd = By.xpath("//*[@id=\"app\"]/div/main/div[3]/div[2]/div[2]/div/div[5]/div[1]");
    By GetProd2= By.xpath("//*[@id=\"app\"]/div/main/div[3]/div[2]/div[2]/div/div[6]/div[1]");
    By GetProd3= By.xpath("//*[@id=\"app\"]/div/main/div[3]/div[2]/div[2]/div/div[3]/div[1]");
    By TxtCant = By.name  ("qty");
    By ListTalla = By.xpath("//*[@id=\"app\"]/div/main/div[2]/div[2]/div/div[2]/div[2]/div[1]/ul/li[1]/a");
    By ListColor = By.xpath("//*[@id=\"app\"]/div/main/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]/a");
    By AddCar = By.className ("button");
    By MsgError = By.xpath("//*[@id=\"app\"]/div/main/div[2]/div[2]/div/div[2]/div[2]/div[3]");
    By LnkTxt = By.linkText("Men");
    By BtnBag = By.className("mini-cart-icon");
    By LnkRemove = By.linkText("Remove");


    //////////////////////////////////////

    By TxtName = By.name("address[full_name]");
    By TxtPhone = By.name("address[telephone]");
    By TxtAddress = By.name("address[address_1]");
    By TxtCity = By.name("address[city]");
    By TxtPostal = By.name("address[postcode]");
    By DpDwCountry = By.id("address[country]");
    By DpDwProvince = By.id("address[province]");
    By BtnPay = By.className("button");

    By BtnConfir = By.xpath("//*[@id=\"checkoutPaymentForm\"]/div[4]/button");



    public ClassPageOrder(WebDriver driver) {
        super(driver);
    }

    public void productMen() throws InterruptedException {
        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div[1]/div[1]/img")));
        click(LnkTxt);
        click(GetProd);
        clear(TxtCant);
        type(Variables.prodCant ,TxtCant);
        click(ListTalla);
        click(ListColor);
        click(AddCar);
        if(isDisplayed(MsgError)){
            do{
                click(AddCar);
            }while (isDisplayed(MsgError));
        }else  {
            System.out.println("Interrupcion en la configuracion");
        }
    }
    public void productDeleted() throws InterruptedException {
        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div[1]/div[1]/img")));
        click(BtnBag);
        if(isDisplayed(LnkRemove)){
            click(LnkRemove);
        }else  {
            System.out.println("Interrupcion en la configuracion");
        }
    }

    public void productEdited() throws InterruptedException {
        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div[1]/div[1]/img")));

       click(BtnBag);
        if(isDisplayed(LnkRemove)){
            click(By.xpath("//*[@id=\"shopping-cart-items\"]/table/tbody/tr/td[1]/div/div[2]/a"));
        }else  {
            System.out.println("Interrupcion en la configuracion");
        }
        clear(TxtCant);
        type(Variables.prodCant ,TxtCant);
        click(ListTalla);
        click(ListColor);
        click(AddCar);
        if(isDisplayed(MsgError)){
            do{
                click(AddCar);
            }while (isDisplayed(MsgError));
        }else  {
            System.out.println("Interrupcion en la configuracion");
        }
    }

    public void productMen2() throws InterruptedException {

        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(LnkTxt));
        click(LnkTxt);
        click(GetProd2);
        clear(TxtCant);
        type(Variables.prodCant ,TxtCant);
        click(ListTalla);
        click(ListColor);
        click(AddCar);
        if(isDisplayed(MsgError)){
            do{
                click(AddCar);
            }while (isDisplayed(MsgError));
        }else  {
            System.out.println("Interrupcion en la configuracion");
        }
    }

    public void productMen3() throws InterruptedException {

        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(LnkTxt));
        click(LnkTxt);
        click(GetProd3);
        clear(TxtCant);
        type(Variables.prodCant ,TxtCant);
        click(ListTalla);
        click(ListColor);
        click(AddCar);
        if(isDisplayed(MsgError)){
            do{
                click(AddCar);
            }while (isDisplayed(MsgError));
        }else  {
            System.out.println("Interrupcion en la configuracion");
        }
    }

    public void payProducts() throws InterruptedException {
        click(LnkTxt);
        wait =  new WebDriverWait(driver, Duration.ofSeconds(Variables.TIME_OUT));
        wait.until(ExpectedConditions.presenceOfElementLocated(BtnBag));
        click(BtnBag);
        if(isDisplayed(LnkRemove)){
            click(By.xpath("//*[@id=\"app\"]/div/main/div[2]/div/div[2]/div/div[2]/div/div[2]/a"));
        }else  {
            System.out.println("Interrupcion en la configuracion");
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(BtnPay));

        if(isDisplayed(By.className("checkbox-checked"))){
            click(By.className("feather-circle"));
            wait.until(ExpectedConditions.presenceOfElementLocated(BtnConfir));
            //driver.switchTo().frame(0);
            windowInFrame(By.xpath("//*[@id=\"card-element\"]/div/iframe"));
            WebElement TxtCarNum = driver.findElement(By.name("cardnumber"));
            TxtCarNum.sendKeys(Variables.card);
            //driver.switchTo().defaultContent();
            windowOutFrame();
            click(BtnConfir);

        }else {
            type(Variables.names, TxtName);
            type(Variables.phone, TxtPhone);
            type(Variables.address, TxtAddress);
            type(Variables.city, TxtCity);
            type(Variables.postal, TxtPostal);

            WebElement dropdownCountry = driver.findElement(DpDwCountry);
            Select selectC = new Select(dropdownCountry);
            selectC.selectByVisibleText("United States");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"checkoutShippingAddressForm\"]/div[1]/div[6]/div")));

            WebElement dropdownProvince = driver.findElement(DpDwProvince);
            Select selectP = new Select(dropdownProvince);
            selectP.selectByVisibleText("Washington");

            WebElement radioMethod = driver.findElement(By.id("method0"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", radioMethod);
            click(BtnPay);
            Thread.sleep(3000);
            //////////////////////////////////
            click(By.className("feather-circle"));
            wait.until(ExpectedConditions.presenceOfElementLocated(BtnConfir));
            //driver.switchTo().frame(0);
            windowInFrame(By.xpath("//*[@id=\"card-element\"]/div/iframe"));
            WebElement TxtCarNum = driver.findElement(By.name("cardnumber"));
            TxtCarNum.sendKeys(Variables.card);
            //driver.switchTo().defaultContent();
            windowOutFrame();
            click(BtnConfir);
        }
    }
}