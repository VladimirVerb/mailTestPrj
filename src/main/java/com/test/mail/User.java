/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mail;

/**
 *
 * @author user
 */
public class User {
    private String nameString;
    private String passwordString;
    
    public User(String nameString, String passwordString){
        this.nameString = nameString;
        this.passwordString = passwordString;
    }
    
    public void SetName(String nameString){
        this.nameString = nameString;
    }
    
    public void SetPassword(String passwordString){
        this.passwordString = passwordString;
    }
    
    public String GetName(){
        return this.nameString;
    }
    public String GetPassword(){
        return this.passwordString;
    }
    
}
