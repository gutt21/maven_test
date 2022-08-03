package com.project.base;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.project.utilies.readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	readconfig read=new readconfig();
	public String username=read.email();
	public String password=read.pass();
	//public String browsername="chrome";
	public static WebDriver driver;	
	 public Logger logger;
	@Parameters("browsername")
	@BeforeTest
	public void setup(String browsername) {
		if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else {
			System.out.println("invalid browser");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://admin-demo.nopcommerce.com/login");
		
		logger=Logger.getLogger("noncommerce");
		PropertyConfigurator.configure("log4j.properties");
		
	}


	@AfterTest
	public void teardown() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}
	
	public void screnshot( String name,String time) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\akash\\eclipse-workspace\\01_maven_test\\screenshot/"+name+" "+time+".png"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
