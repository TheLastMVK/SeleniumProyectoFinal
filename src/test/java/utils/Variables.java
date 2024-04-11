package utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
public class Variables {
    public static String mail = "ing.jorgecisneroscab99@gmail.com";
    public static String names = "Jorge Daniel Cisneros Cabello";
    public static String BASE_URL = "https://demo.evershop.io/";
    public static String password = "JorDanCis123";
    public static String phone = "992229526";
    public static String address = "Av. Rafael Escardo 620";
    public static String city = "Lima - San Miguel";
    public static String postal = "20002";
    public static String card = "42424242424242420424242";
    final static Random random = new Random();
    final static Integer ranCant = random.nextInt(10)+1;
    public static String prodCant = String.valueOf(ranCant);
    public static int TIME_OUT = 10;


}