package com.selenium.hepsiburadatest;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageTest {
    @Test
    public void open() throws InterruptedException {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        System.setProperty("webdriver.chrome.driver","C:\\Users\\gs_fu\\Documents\\Selenium\\ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open url
        driver.get("https://www.hepsiburada.com/");

        Thread.sleep(1000);

        System.out.println("Open and Close Test Successful");
        //close url
        driver.close();



    }
}
