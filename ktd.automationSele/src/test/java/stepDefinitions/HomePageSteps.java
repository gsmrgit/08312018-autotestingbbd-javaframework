package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;

public class HomePageSteps {
//	WebDriver driver;
	HomePage homePage;
//	PageObjectManager pageObjectManager;	
//	WebDriverManager webDriverManager;
	TestContext testContext;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage= testContext.getPageObjectManager().getHomePage();
		
	}
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
//		testContext= new TestContext();
		//webDriverManager = new WebDriverManager();
	//	new TestContext().getPageObjectManager().getHomePage().navigateTo_HomePage();
		//driver = webDriverManager.getDriver();
	//	pageObjectManager = new PageObjectManager(driver);
	//	homePage = pageObjectManager.getHomePage();
	//	homePage.navigateTo_HomePage();	
//		pageObjectManager= testContext.getPageObjectManager();
//		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();	
	}
	
	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product)  {
		homePage.perform_Search(product);
	}

}
