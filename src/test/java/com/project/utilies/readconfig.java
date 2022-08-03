package com.project.utilies;
import java.io.FileInputStream;
import java.util.Properties;
public class readconfig {

	
	
	Properties prop;
	public readconfig() {
		
		try {
			FileInputStream input =new FileInputStream("C:\\Users\\akash\\eclipse-workspace\\01_maven_test\\configuration\\config.properties");
		prop=new Properties();
		prop.load(input);
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public String email() {
		return prop.getProperty("email");
	}
	
	public String pass() {
		return prop.getProperty("password");
	}
	
	public String browser() {
		return prop.getProperty("browser");
	}
}
