package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass {

	@Test(groups="Sanity")
	public void verify_Login() throws InterruptedException {
		logger.info("**** Starting TC_001_LoginTest ****");
		// here we are passing driver, because in loginpage constructor is
		// there,constructor is trying to invoke at runtime
		try {
			LoginPage lp = new LoginPage(driver);
			lp.setUsername("standard_user");
			lp.setPassword("secret_sauce");
			lp.clickLogin();
			logger.info("Clicked on Login");

			logger.info("Validating expected message");
			String confmsg = lp.getConfirmationMsg();
			if (confmsg.equals("Swag Labs")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
			// Assert.assertEquals(confmsg, "Swag Labs");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC_001_LoginTest ****");
	}
  @Test
	public void verify_products() {
		logger.info("*** Starting TC_002_ProductsTest ***");
		try
		{
		// products page
		ProductPage pp = new ProductPage(driver);
		Boolean targetPage = pp.isMyProductsExists();
		// Assert.assertEquals(targetPage, true,"Login failed");
		pp.clickLogout();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** finished TC_002_ProductsTest ***");

	}
  

}