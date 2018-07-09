/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author user
 */
public class AbstractPage {
    protected WebDriver driver;
    protected LogHTML logHTML;
    protected int screenshotCount=0;
    
    public boolean isLogging(){
        return logHTML == null;
    }
    
    public StringBuilder getScreenshot() {
        screenshotCount++;
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
	Date date = new Date();
        
        StringBuilder screenshotName = new StringBuilder("screeshot_"+Integer.toString(screenshotCount)+" "+dateFormat.format(date)+".png");
        StringBuilder screenshotPath = new StringBuilder(logHTML.GetLogPath() + screenshotName);
        File DestFile=new File(screenshotPath.toString());
        
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(scrFile);
            os = new FileOutputStream(DestFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } 
        catch(Exception e){
            e.printStackTrace();
        }
        return screenshotName;
    }        
}
