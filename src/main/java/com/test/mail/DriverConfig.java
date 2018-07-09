/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mail;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author user
 */
public class DriverConfig {
    private WebDriver driver;
    private LogHTML log;
    
    public DriverConfig(){
        System.setProperty("webdriver.chrome.driver", "e:/selenium/chromedriver.exe");
        log = new LogHTML("Results_");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mail.ru");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }  
    public WebDriver getDriver(){
        return driver;
    }
    public LogHTML getLog(){
        return log;
    }
    
    public void destroyConfig(){
        if(driver != null) driver.close();
        if(log != null) log.CloseLog();
    }    
}
