package Stepdefinition;

public class liststep {

	
	/*WebDriver driver;

	String url = "https://www.crmpro.com/";

	@Given("^I navigate to Facebook page$")
	public void navigateToFacebook() throws Throwable {
		System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		  driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
		 driver.manage().window().maximize();
	    driver.get(url);
	}

	@Then("^I enter all required details$")
	public void enterAllDetails(DataTable testData) throws Throwable {
		List<String> details = testData.asList(String.class);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(details.get(0));
		driver.findElement(By.name("lastname")).sendKeys(details.get(1));
		driver.findElement(By.name("reg_email__")).sendKeys(details.get(2));
		driver.findElement(By.name("reg_passwd__")).sendKeys(details.get(3));
		Select date = new Select(driver.findElement(By.id("day")));
		Select month = new Select(driver.findElement(By.id("month")));
		Select year = new Select(driver.findElement(By.id("year")));
		String[] dob = details.get(4).split("-");
		date.selectByVisibleText(dob[0]);
		month.selectByVisibleText(dob[1]);
		year.selectByVisibleText(dob[2]);

		String genderXpath = String.format("//label[text()='%s']//preceding-sibling::input[@type='radio']",
				details.get(5));

		driver.findElement(By.xpath(genderXpath)).click();
	}

	@Then("^I Clicked on the signup button$")
	public void clickOnSgnUpButton() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("^I enter username and password$")
	public void enterUsernameAndPassword(DataTable testData) throws Throwable {

		Map<String, String> data = testData.asMap(String.class, String.class);

		driver.findElement(By.id("email")).sendKeys(data.get("username"));
		driver.findElement(By.id("pass")).sendKeys(data.get("password"));

	}

	@Then("^I Clicked on the login button$")
	public void clickOnloginButton() throws Throwable {
		driver.findElement(By.id("u_0_2")).click();
	}

	@Then("^I verified that login is successful$")
	public void verifyLoginIsSuccessful() throws Throwable {
		System.out.println(driver.getTitle());
	}
*/
	
}
