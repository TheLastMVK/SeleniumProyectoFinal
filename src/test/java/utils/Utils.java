package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class Utils {

    public static void takeScreenOrder(WebDriver driver, String idOrder) throws Exception{
        File source =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("./screenshots" + idOrder+ ".png"));
    }
}
