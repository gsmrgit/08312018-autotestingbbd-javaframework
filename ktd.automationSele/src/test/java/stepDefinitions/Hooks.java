package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	@Before
	public void BeforeSteps() {
		/*all steps before running test*/
//		System.out.println("start ready to run");
	}
	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().quitDriver();
	}
}
