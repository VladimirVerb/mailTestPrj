/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author user
 */
public class DriverConfig {
    private RemoteWebDriver driver;
    private LogHTML log;
    private String browserName = "chrome";
    public Properties prop = new Properties();
    
    public DriverConfig(String hubString){
        try{
            //System.setProperty("webdriver.chrome.driver", "e:/selenium/chromedriver.exe");
            //driver = new ChromeDriver();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars"); // starting from Chrome 57 the info bar displays with "Chrome is being controlled by automated test software."
            options.addArguments(Arrays.asList("--start-maximized"));
            capabilities.setBrowserName(browserName);
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new RemoteWebDriver(new URL(hubString),capabilities);
            driver.manage().window().maximize();
            driver.get("http://mail.ru");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            log = new LogHTML("Results_");
        } catch (Exception e){
            e.printStackTrace();
        }
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
