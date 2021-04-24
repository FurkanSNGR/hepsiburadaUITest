package com.selenium.hepsiburadatest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class GoBasket {
    @Test
    public void gobasket() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\gs_fu\\Documents\\Selenium\\ChromeDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.hepsiburada.com/");

        WebElement select1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div/div[2]/div[3]/div[2]/span/span[1]"));
        Thread.sleep(1000);
        WebElement select2 = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        Thread.sleep(2000);

        Actions action = new Actions(driver);
        action.click(select1).click(select2).build().perform();

        Thread.sleep(2000);

        //username
        WebElement txtbx_username = driver.findElement(By.id("txtUserName"));
        txtbx_username.sendKeys("tester_123@gmail.com");

        //password
        WebElement txtbx_password = driver.findElement(By.id("txtPassword"));
        txtbx_password.sendKeys("Login123");

        //submit
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(2000);

        //main categories
        List<WebElement>select = driver.findElements(By.className("sf-MenuItems-1Sj7h"));
        Random rand = new Random();
        int list = rand.nextInt(select.size());
        select.get(list).click();
        Thread.sleep(1000);

        //dropdown
        List<WebElement>select6 = driver.findElements(By.className("sf-ChildMenuItems-2DIVP"));
        Random rand2 = new Random();
        int list2 = rand2.nextInt(select6.size());
        select6.get(list2).click();
        Thread.sleep(1000);

        //brand
        List<WebElement>select3 = driver.findElements(By.className("show-all-brands"));
        Random rand3 = new Random();
        int list3 = rand3.nextInt(select3.size());
        select3.get(list3).click();
        Thread.sleep(1000);

        //price min_limit
        WebElement minprice = driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div/div/div/div[1]/section/div[1]/div[2]/div/div/ol/li[1]/div/div/div[1]/input"));
        minprice.sendKeys("10");
        Thread.sleep(1000);

        //price max_limit
        WebElement maxlimit = driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div/div/div/div[1]/section/div[1]/div[2]/div/div/ol/li[1]/div/div/div[3]/input"));
        maxlimit.sendKeys("4000");
        Thread.sleep(1000);

        //price_go
        driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div/div/div/div[1]/section/div[1]/div[2]/div/div/ol/li[1]/div/div/div[4]/button")).click();


        //product-list
        List<WebElement>select4 = driver.findElements(By.className("product-list"));
        Random rand4 = new Random();
        int list4 = rand4.nextInt(select4.size());
        select4.get(list4).click();
        Thread.sleep(1000);

        //product-name_and_price
        //product-name
        WebElement productname = driver.findElement(By.xpath("//*[@id=\"product-name\"]"));
        System.out.print("product-name = ");
        System.out.println(productname.getText());

        //product-detail-price
        WebElement detailprice = driver.findElement(By.xpath("//*[@id=\"offering-price\"]"));
        System.out.print("product-detail-price = ");
        System.out.println(detailprice.getText());
        Thread.sleep(1000);

        //add-basket
        driver.findElement(By.xpath("//*[@id=\"addToCart\"]")).click();
        Thread.sleep(2000);

        //quantity
        WebElement basketquantity = driver.findElement(By.xpath("//*[@id=\"cartItemCount\"]"));
        System.out.print("product-basket-quantity = ");
        System.out.println(basketquantity.getText());
        Thread.sleep(1000);

        //quantity
        if((basketquantity.getText().equals("1"))){
            System.out.println("quantity accept");
        }
        else{
            System.out.println("quantity not accept");
        }

        Thread.sleep(2000);

        //go-basket
        driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]")).click();

        Thread.sleep(2000);
        //2basket
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/section/section/ul/li/div/div/div[2]/div[4]/div[2]/div/a[1]")).click();

        Thread.sleep(1000);

        //basket-totalprice
        WebElement basketprice= driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[3]/div/div/div[1]/div[1]/span[2]/div/div"));
        System.out.print("basket-price = ");
        System.out.println(basketprice.getText());
        Thread.sleep(1000);

        //shipping
        WebElement shipping = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[3]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div/div[2]/span[1]"));
        System.out.print("shipping price = ");
        System.out.println(shipping.getText());
        Thread.sleep(1000);


        if((shipping.getText().equals("Bedava"))){
            System.out.println("KARGO ÜCRETİ YOK");
        }
        else{
            WebElement shipping2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[3]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/div/div/div/div[2]/span[2]"));
            System.out.print("shipping price = ");
            System.out.println(shipping2.getText());
        }
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"continue_step_btn\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[1]/div[1]/div/div[1]/div/div[2]/span")).click();
        Thread.sleep(2000);

        //address
        WebElement name = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[1]/div/div[1]/div/div[1]/div/input"));
        name.sendKeys("name");

        WebElement surname = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[1]/div/div[1]/div/div[2]/div/input"));
        surname.sendKeys("surname");

        WebElement phone = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[1]/div/div[2]/div/div/div/div/div/input"));
        phone.sendKeys("5359999999");
        Thread.sleep(2000);


        //city-select
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[2]/div/div[1]/div/div[1]/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[2]/div/div[1]/div/div[1]/div/input")).click();
        Thread.sleep(1000);
        WebElement citygo = driver.findElement(By.xpath("//*[@id=\"react-select-25-option-0\"]"));
        citygo.click();
        Thread.sleep(1000);
        //----------------------------

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[2]/div/div[1]/div/div[2]/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"react-select-21-option-0\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[2]/div/div[1]/div/div[3]/div/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"react-select-23-option-0\"]")).click();
        Thread.sleep(2000);

        WebElement address = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[2]/div/div[2]/div/div[1]/div/textarea"));
        address.sendKeys("myhomeadress");
        Thread.sleep(2000);

        WebElement adressname = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[2]/div/div[2]/div/div[2]/div/input"));
        adressname.sendKeys("home");
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div/form/fieldset[4]/div/div/div/button[1]")).click();
        Thread.sleep(2000);

        //contiinue
        driver.findElement(By.xpath("//*[@id=\"continue_step_btn\"]")).click();
        Thread.sleep(2000);

        //credit card
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(2000);

        WebElement creditcard = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/div/div[1]/form/div[1]/div[1]/div/div/div/input"));
        creditcard.sendKeys("5555 5555 5555 5555");
        Thread.sleep(1000);

        WebElement creditname = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/div/div[1]/form/div[1]/div[2]/div/div/div/input"));
        creditname.sendKeys("name surname");
        Thread.sleep(1000);

        WebElement creditdate = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/div/div[1]/form/div[1]/div[3]/div/div[1]/div/input"));
        creditdate.sendKeys("0221");
        Thread.sleep(1000);

        WebElement creditcvc = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/div/div[1]/form/div[1]/div[3]/div/div[1]/div/input"));
        creditcvc.sendKeys("111");
        Thread.sleep(1000);

        //go-home-page
        driver.findElement(By.xpath("/html/body/div/div/div/header/div/div/div[1]/div/a/svg")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/a/svg/path")).click();
        Thread.sleep(2000);

        //go-basket-again
        driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]")).click();
        Thread.sleep(1000);

        //basket-clear
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/section/section/ul/li/div/div/div[2]/div[4]/div[2]/div/a[2]")).click();
        Thread.sleep(1000);

        //go-profile
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div/div[4]/div[2]/div/div/span")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div/div/div/div[4]/div[2]/div/div[2]/div[2]/ul/li[1]/a")).click();
        Thread.sleep(1000);

        //go-my-address
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/div/div/div/div[2]/div/div[6]/div/div/div[2]/a[6]")).click();
        Thread.sleep(1000);

        //delete-address
        driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div/div[4]/div/div/div/div/ul/li[2]/div/div[1]/a[1]")).click();
        Thread.sleep(1000);

        driver.close();



























    }

}
