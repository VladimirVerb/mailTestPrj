/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mail;

import static java.lang.Thread.sleep;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author user
 */
public class IndexPage extends AbstractPage{
    @FindBy (xpath = "//input[@id = 'mailbox:login']")
    @CacheLookup
    private WebElement loginElement;
    @FindBy (xpath = "//input[@id = 'mailbox:password']")
    @CacheLookup
    private WebElement pwdElement;
    @FindBy (xpath = "//input[@value='Войти']")
    @CacheLookup
    private WebElement submitElement;
    @FindBy (xpath = "//span[contains(text(),'Написать письмо')]")
    private WebElement newMailElement;
    @FindBy (xpath = "//textarea[@data-original-name='To']")
    private WebElement toElement;
    @FindBy (xpath = "//input[@name='Subject']")
    private WebElement captionElement;
    @FindBy (xpath = "//body[@id='tinymce']")
    private WebElement contentElement;
    @FindBy (xpath = "//span[contains(text(),'Отправить')]")
    private WebElement sendMailElement;
    @FindBy (className = "message-sent__title")
    private WebElement resultElement;
    @FindBy (className = "compose__editor__frame")
    private WebElement contentDivElement;
    @FindBy (xpath = "//body[@id='tinymce']")
    private WebElement contentBodyElement;
   
    public IndexPage(WebDriver driver, LogHTML logHTML){
        this.driver = driver;
        this.logHTML = logHTML;
        PageFactory.initElements(driver, this);
    }    
    
    public IndexPage login(User user){
        try {
            logHTML.WriteLog(new StringBuilder("Before"),getScreenshot());
            loginElement.sendKeys(user.GetName());
            pwdElement.sendKeys(user.GetPassword());
            submitElement.click();
            newMailElement.isDisplayed();
            System.out.println("Success");
            logHTML.WriteLog(new StringBuilder("After"),getScreenshot());
        } catch (Exception e) {
            System.out.println("Element not found");
            logHTML.WriteLogError(new StringBuilder("Element not found"),getScreenshot());
        }
        return this;
    }
    public IndexPage createMail(String toString, String captionString,String contenetString){
        try {
            logHTML.WriteLog(new StringBuilder("Before"),getScreenshot());
            newMailElement.click();
            toElement.sendKeys(toString);
            captionElement.click();
            captionElement.sendKeys(captionString);
            contentDivElement.click();
            driver.switchTo().defaultContent();
            sleep(10000);
            List<WebElement> frames = driver.findElements(By.xpath("//iframe"));
            if(frames.size()==5){
                int index = frames.size()-1;
                driver.switchTo().frame(frames.get(index));
                contentBodyElement.sendKeys(contenetString);
                driver.switchTo().defaultContent();
                logHTML.WriteLog(new StringBuilder("Before Submit"),getScreenshot());
                sendMailElement.click();
                resultElement.isDisplayed();
                logHTML.WriteLog(new StringBuilder("After Submit"),getScreenshot());
            }else{
                logHTML.WriteLogError(new StringBuilder("Element not found"),getScreenshot());
            }
        } catch (Exception e) {
            System.out.println("Element not found");
            logHTML.WriteLogError(new StringBuilder("Element not found"),getScreenshot());
        }
        return this;
    }
    
}
