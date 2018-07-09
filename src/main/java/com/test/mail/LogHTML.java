/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class LogHTML {
    private FileOutputStream fileStream;
    private String dirNameString;
    private static String openLogHTML= "<html><style>td{border:1px solid black;}</style><body><table>";
    private static String closeLogHTML= "</table></body></html>";
    
    public LogHTML(String dirNameString){
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	Date date = new Date();
        this.dirNameString = dirNameString+dateFormat.format(date);
        new File(this.dirNameString).mkdir();
        try{
            fileStream = new FileOutputStream(new File(this.dirNameString+"\\index.html"));
            fileStream.write(openLogHTML.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void WriteLog(String text){
        try{
            fileStream.write(text.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void WriteLog(StringBuilder descriptionString, StringBuilder imgPath){
        String trString = "<tr><td>"+descriptionString+"</td><td><img src='"+imgPath+"'/></td></tr>";
        try{
            fileStream.write(trString.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void WriteLogError(StringBuilder descriptionString, StringBuilder imgPath){
        String trString = "<tr><td style='background-color:#FF0000'>"+descriptionString+"</td><td><img src='"+imgPath+"'/></td></tr>";
        try{
            fileStream.write(trString.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void CloseLog(){
        try {
            fileStream.write(closeLogHTML.getBytes());
            fileStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String GetLogPath(){
        return dirNameString+"\\";
    }    
}
