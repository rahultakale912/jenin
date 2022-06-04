package Pageoperation;

public class mouseAction {

/*	public void withoutselect() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		config.driver = new ChromeDriver();
		config.driver.get("https://www.google.com/");
		config.driver.manage().window().maximize();
		config.driver.get("https://www.crmpro.com/");
	     Thread.sleep(2000);
	     config.driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("ranjitk");
	     config.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("ranjit7001");
	     config.driver.findElement(By.xpath("//input[@value='Login']")).click();
	     Thread.sleep(2000);
	     config.driver.switchTo().frame("mainpanel");
	     Actions action = new Actions(config.driver);  
	     WebElement optionsList = config.driver.findElement(By.xpath("//a[@title='Contacts']"));
	  
	     action.moveToElement(optionsList).perform();
	 
	     WebElement suboptionsList =config.driver.findElement(By.xpath("//a[@title='New Contact']"));
	     suboptionsList.click();
	     
	
	     WebDriverWait wait = new WebDriverWait(config.driver, 20);
	     WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Date selector']")));
	     passwordElement.click();
	    
	      Thread.sleep(4000);
	     List<WebElement> allDates = config.driver.findElements(By.tagName("td"));
	     System.out.println(allDates);
	    
	     WebElement dateWidget = config.driver.findElement(By.xpath("//div[@class='calendar']//table"));
	     List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
	     System.out.println(columns);

	     for (WebElement cell: columns){
	        //Select 13th Date 
	        if (cell.getText().equals("13")){
	           cell.click();
	           break;
	      }
	   
	     }
	
	         
	}
	
	public static void main(String[] args) throws InterruptedException {
		mouseAction m = new mouseAction();
		m.withoutselect();

	}*/

}
