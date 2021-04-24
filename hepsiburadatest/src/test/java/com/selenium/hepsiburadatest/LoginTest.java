package com.selenium.hepsiburadatest;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class LoginTest {
    @Test
    public void login() throws InterruptedException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

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

        String actualUrl="https://www.hepsiburada.com/";
        String expectedUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        System.out.println("Login Test Succesful");

        Thread.sleep(1000);

        WebElement openbasket = driver.findElement(By.id("shoppingCart"));
        openbasket.click();


        WebElement basketprice = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/h1"));

        if((basketprice.getText().equals("Sepetin şu an boş"))){
            System.out.println("BASKET PRICE 0'TL..");
        }
        else{
            WebElement price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[3]/div/div/div[1]/div[1]/span[2]/div/div"));
            System.out.println(price.getText());
        }

        driver.close();
    }
}
