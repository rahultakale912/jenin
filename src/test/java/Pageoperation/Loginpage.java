package Pageoperation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import configration.config;

public class Loginpage {

	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
	WebElement username;
	public void username(String name)
    {
       username.sendKeys(name);
	}
	 @FindBy(how=How.XPATH,using="//input[@placeholder='Password']")
	 WebElement password;
	 public void password(String pass)
	 {
		 password.sendKeys(pass);
	 }
     
	 @FindBy(how=How.XPATH, using="//input[@value='Login']")
	 WebElement loginclick;
	 public void click()
	 {
		 loginclick.click();
	 }
	 
	 @FindBy(how=How.XPATH,using="//a[text()='Pipeline']")
		WebElement pipeline;
		public void clickpipline()
		{
			config.driver.switchTo().frame("mainpanel");
			pipeline.click();
		}
	
		
		@FindBy(how=How.XPATH,using="//a[@href='https://www.crmpro.com/index.cfm?logout=1']//i")
		WebElement checklogout;
		public void checklogin()
		{
			
			config.driver.switchTo().frame("mainpanel");
			checklogout.click();
			String title=config.driver.getTitle();
			System.out.println(title);
		}
}
