package Stepdefinition;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pageoperation.Homepage;
import Pageoperation.Loginpage;
import configration.config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class batchfilestepdef<V> {

	Loginpage lp;
	Homepage hp ;
	
	
	@Given("^: Open the firefox1$")
	public void open_the_firefox() throws Throwable {
	    
		//System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","D://selenium//chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rahul\\Desktop\\F\\responsibilities\\design phase\\FinsysProject\\AllDrivers");
		WebDriver driver = new FirefoxDriver();
		
		config.driver = new ChromeDriver();
		config.driver.get("https://www.google.com/");
		config.driver.manage().window().maximize();
		config.driver.get("https://www.crmpro.com/");
	     Thread.sleep(2000);
	}
  
	
    @When("^: enter the uname1 \"(.*)\"$")
    public void enter_the_uname(String name) throws Throwable {
	
    	
    lp= new Loginpage(config.driver);
	lp.username(name);
	Thread.sleep(2000);
    
}

   @When("^: Enter Password1 \"(.*)\"$")
   public void enter_Password(String pass) throws Throwable {
	
	lp.password(pass);
	
     }

   @Then("^: Click login button1$")
    public void click_login_button() throws Throwable {
	lp.click();
	Thread.sleep(2000);
	  config.driver.switchTo().frame("mainpanel");
	
 
   }
   


   @Given("^: User enter username and password \"([^\"]*)\" and \"([^\"]*)\"$")
   public void user_enter_username_and_password_and(String arg1, String arg2) throws Throwable {
	   System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		config.driver = new ChromeDriver();
		config.driver.get("https://www.google.com/");
		config.driver.manage().window().maximize();
		config.driver.get("https://www.crmpro.com/");
	     Thread.sleep(2000);
	     lp= new Loginpage(config.driver);
	     
	 	lp.username(arg1);
	 	Thread.sleep(2000);	   
	 	lp.password(arg2);
	 	lp.click();
		Thread.sleep(2000);
   }

   @SuppressWarnings("unchecked")
@When("^: User click on button$")
   public void user_click_on_button() throws Throwable {

	   Thread.sleep(5000);
	   config.driver.switchTo().frame("mainpanel");
	   WebElement alertbtn = config.driver.findElement(By.xpath("//a[@title='Alerts1']"));
	   alertbtn.click();
	   Thread.sleep(5000);
	   WebDriverWait waitForFormLabel = new WebDriverWait(config.driver, 50);      
       By inputArea = By.xpath("//table[@class='datacard']//tbody//tr//td");
       List <WebElement> myIput = config.driver.findElements(inputArea);
       waitForFormLabel.until((Function<? super WebDriver, V>) ExpectedConditions.visibilityOfAllElements(myIput));
       
       String str ="Ownership change";
       for (int i = 0; i < myIput.size(); i++) {
    	   
		if(myIput.get(i).getText().contains(str))
		{
			System.out.println(myIput.get(i+1).getText());
		}
		}
	 }

   @Then("^: Verify the data in table$")
   public void verify_the_data_in_table() throws Throwable {
	   
   }

 
   @Given("^:Is on main page$")
   public void is_on_main_page() throws Throwable {
	   System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		config.driver = new ChromeDriver();
		config.driver.get("https://www.google.com/");
		config.driver.manage().window().maximize();
		config.driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
	     Thread.sleep(2000);
       
   }

   @SuppressWarnings("unchecked")
@When("^:Click current date$")
   public void click_current_date() throws Throwable {
       
	   WebElement el = config.driver.findElement(By.xpath("//span[@class='k-link k-link-date']"));
	   el.click();
	   Thread.sleep(1000);
	   WebElement el1 = config.driver.findElement(By.xpath("//div[@class='k-header']//a[@class='k-link k-nav-fast']"));
	   el1.click();
	   Thread.sleep(2500);
	   WebElement el2= config.driver.findElement(By.xpath("//div[@class='k-header']//a[@class='k-link k-nav-fast k-state-hover']"));
	   el2.click();
	   Thread.sleep(5000);
	  
	   List<WebElement> listofyear =config.driver.findElements(By.xpath("//table[@class='k-content k-meta-view k-decade']//tbody//tr//td"));
     
      String st ="2021";
 
    for(int k=0;k<listofyear.size();k++)
    {
    	
    	if(listofyear.get(k).getText().contentEquals(st))
    	{
    		listofyear.get(k).click();
    		break;
    	}
    	
    }
   System.out.println("-1");
   }

   @SuppressWarnings("unchecked")
@Then("^:Selected date current date or not$")
   public void selected_date_current_date_or_not() throws Throwable {
	   String st1="Jan";     
	    WebDriverWait waitForFormLabel1 = new WebDriverWait(config.driver,500);      
	    By inputArea1 = By.xpath("//a[@class='k-link']");
	    
	    Thread.sleep(5000);
	    List <WebElement> limonth = config.driver.findElements(inputArea1);
	    waitForFormLabel1.until((Function<? super WebDriver, V>) ExpectedConditions.visibilityOfAllElements(limonth));
	    
	   
	    
	     for (int l = 0; l <limonth.size(); l++) {
			if (limonth.get(l).getText().contains(st1)) 
			{
				
				limonth.get(l).click();
				break;
			}
		}
	   
     
	     List<WebElement> dates = config.driver.findElements(By.xpath("//a[@class='k-link']"));
	     for(int g =0; g<dates.size();g++)
	     {
	    	 if(dates.get(g).getText().contains("4"))
	    	 {
	    		 dates.get(g).click();
	    		 break;
	    	 }
	     }
   }
   
   
   
}
