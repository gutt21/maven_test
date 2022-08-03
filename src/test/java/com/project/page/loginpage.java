package com.project.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.project.base.baseclass;

public class loginpage extends baseclass {

	@FindBy(id = "Email")
	WebElement id;

	@FindBy(id = "Password")
	WebElement pass;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement click;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement log;
	
	public loginpage() {		
		PageFactory.initElements(driver, this);
	}



	public void user(String name) {
		id.clear();
		id.sendKeys(name);
	}

	public void pass(String pas) {
		pass.clear();
		pass.sendKeys(pas);
	}

	public void login() {
		click.click();

	}
	
	public void verifylogin() {
	String ag=driver.getTitle();
	String exe="Dashboard / nopCommerce administration";
	Assert.assertEquals(ag, exe);
	
	}
	
	
	public void logout() {
		log.click();

	}
	
	public void verifylogout() {
		String ag=driver.getTitle();
		String exe="Your store. Login";
		Assert.assertEquals(ag, exe);
	}
	
	
}
