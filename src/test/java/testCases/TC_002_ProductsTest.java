package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC_002_ProductsTest extends BaseClass {
	@Test
	public void verify_products() {
		logger.info("*** Starting TC_002_ProductsTest ***");
		try
		{
		// products page
		ProductPage pp = new ProductPage(driver);
		Boolean targetPage = pp.isMyProductsExists();
		// Assert.assertEquals(targetPage, true,"Login failed");
		
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** finished TC_002_ProductsTest ***");

	}

}
