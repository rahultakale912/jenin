package Stepdefinition;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import configration.config;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	
	 static Integer num=0;
	  
	  @After(order=0)
	  public void cbrowser()
	  {  

		 // config.driver.quit();
	  }
	   	@After(order=1)
	   	public void tearDown(Scenario scenario) {
	   	   
	   	  if(scenario.isFailed())
	   	  {
	   		num++;
	   		  System.out.println("fail scenrio"+scenario.isFailed());
	   		File src=((TakesScreenshot)config.driver).getScreenshotAs(OutputType.FILE);
	   		try {
	   			
				FileUtils.copyFile(src, new File("D:\\"+""+num+ scenario.getName()+".png"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	   	  }
	   	  else
	   	  {
	   		  System.out.println("Pass scenario");
	   	  }
	   		
	   	}
	   

}
