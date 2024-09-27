package com.automation.utils;

import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    static Properties prop;

    public static void initConfig(){
        prop=new Properties();
        try {
            prop.load(new FileInputStream("C:\\ust\\TestNGFramework\\src\\test\\resources\\config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getConfigValue(String key){
        return (prop.getProperty(key));
    }
}
