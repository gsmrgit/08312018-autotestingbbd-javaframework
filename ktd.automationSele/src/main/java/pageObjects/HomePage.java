package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.TestContext;
//import dataProvider.ConfigFileReader;
import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
//	TestContext testContext;
//	ConfigFileReader configFileReader;
	String url;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		configFileReader= new ConfigFileReader();
//		url= configFileReader.getUrl();
		url = FileReaderManager.getInstance().getConfigReader().getUrl();
	}
	
	public void perform_Search(String search) {
		driver.navigate().to(url+"/?s=" + search + "&post_type=product");
		//debug
//		System.out.println("end of perform_Search");
	}
	
	public void navigateTo_HomePage() {
		driver.get(url);
	}

}
