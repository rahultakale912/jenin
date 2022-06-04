package Stepdefinition;

import java.io.File;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import Pageoperation.Homepage;
import Pageoperation.Loginpage;
import configration.config;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class step {

	
	
	
	Loginpage lp;
	Homepage hp ;
	
	@Given("^: Open the firefox$")
	public void open_the_firefox() throws Throwable {
	    
		System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		config.driver = new ChromeDriver();
		config.driver.get("https://www.google.com/");
		config.driver.manage().window().maximize();
		config.driver.get("https://www.crmpro.com/");
	     Thread.sleep(2000);
	}
  
	
    @When("^: enter the uname \"(.*)\"$")
    public void enter_the_uname(String name) throws Throwable {
	//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
    	
    lp= new Loginpage(config.driver);
	lp.username(name);
	Thread.sleep(2000);
    
}

   @When("^: Enter Password \"(.*)\"$")
   public void enter_Password(String pass) throws Throwable {
	//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
	lp.password(pass);
	//driver.findElement(By.xpath("//input[@value='Login']")).click();
     }

   @Then("^: Click login button$")
    public void click_login_button() throws Throwable {
	lp.click();
	Thread.sleep(2000);
  
	lp.checklogin();
	config.driver.close();
   }
	

@Given("^: Open the chrome$")
public void open_the_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions

	System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
	config.driver = new ChromeDriver();
	config.driver.get("https://www.google.com/");
	config.driver.manage().window().maximize();
	config.driver.get("https://www.crmpro.com/");
     Thread.sleep(2000);
     
}

@When("^: passing username \"([^\"]*)\"$")
public void passing_username(String arg1) throws Throwable {
	lp= new Loginpage(config.driver);
	lp.username(arg1);
	Thread.sleep(2000);
    
   
}

@When("^: passing Password \"([^\"]*)\"$")
public void passing_Password(String pass) throws Throwable {
	lp.password(pass);
	lp.click();
	Thread.sleep(2000);
	//config.driver.close();
}

@Then("^: current date selected or not \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
public <V> void current_date_selected_or_not( String d,String month,String year) throws Throwable {
	
  Thread.sleep(5000);
  config.driver.switchTo().frame("mainpanel");
  
  Thread.sleep(5000);
  Select sectmonths = new Select(config.driver.findElement(By.xpath("//Select[@name='slctMonth']")));
  sectmonths.selectByVisibleText(month);
  
  Thread.sleep(5000);
  Select sectyear = new Select(config.driver.findElement(By.xpath("//Select[@name='slctYear']")));
  sectyear.selectByVisibleText(year);
  
 Thread.sleep(5000);
  List<WebElement> ds = config.driver.findElements(By.xpath("//div[@id='crmcalendar']//table//tbody//tr[2]//td//table//tbody//tr//td"));
  
 for(int i=0 ;i<ds.size();i++)
 {
	 
	 //System.out.println(ds.get(i).getText());
	 if(ds.get(i).getText().equals(d))
	 {
		 ds.get(i).click();
		 
		 
	 }
 }
//config.driver.quit();
  }
	@After 
public void tearDown(ITestResult result){ 
	System.out.println("After call");
	if(ITestResult.FAILURE==result.getStatus()){
		try{
			 // To create reference of TakesScreenshot
			 TakesScreenshot screenshot=(TakesScreenshot)config.driver;
			 // Call method to capture screenshot
			 File src=screenshot.getScreenshotAs(OutputType.FILE);
			 // Copy files to specific location 
			 // result.getName() will return name of test case so that screenshot name will be same as test case name
			 FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
			 System.out.println("Successfully captured a screenshot");
			 }catch (Exception e){
			 System.out.println("Exception while taking screenshot "+e.getMessage());
			 } 
			 }
	config.driver.quit();
			 }
}
	  


