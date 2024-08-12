package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class T003_LoginDDT extends BaseClass {
	// we need add extra parameter dataProviderClass=classname.class if
	// dataproviders are created
	// in other class or package
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("**** starting TC_003_LoginDDT ****");
		try {
			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setUsername(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			

			// products page
			ProductPage pp = new ProductPage(driver);
			Boolean targetPage = pp.isMyProductsExists();

			/*
			 * data is valid - Login success - test pass - logout Login failed - test fail
			 */
			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					pp.clickLogout();
					Assert.assertTrue(true);
				} else {ProductPage
					Assert.assertTrue(false);
				}
			}

			/*
			 * data is invalid - Login success - test fail - logout Login failed - test pass
			 */
			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					pp.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC_003_LoginDDT ****");

	}
}
