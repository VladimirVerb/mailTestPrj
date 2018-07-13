/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author user
 */
public class Data {
    private Properties properties = new Properties();
    
    public Data(){
	InputStream input = null;
	try {
            input = new FileInputStream("config.properties");
            properties.load(input);
	} catch (IOException ex) {
            ex.printStackTrace();
	} finally {
            if (input != null) {
                try {
                        input.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
	}    
    }
    
    public User InitUser(){
        return new User(properties.getProperty("user"), properties.getProperty("password"));
    }
    
    public String GetHUB(){
        return properties.getProperty("hub");
    }
    
}
