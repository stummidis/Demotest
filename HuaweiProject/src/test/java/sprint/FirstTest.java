package sprint;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import test.framework.BaseTest;

public class FirstTest extends BaseTest {
	
	public static String siturl = "https://www.amazon.com";
	
	@Test
	public void verification_Test(){
		openBrowser("Chrome");
		navigate(driver, siturl);
		searchtext("Nikon");
		sortresult("High to Low");
		select_product_link_and_verify_text(1, "Nikon D3X");
				
	}
	@AfterTest
	public void teardown(){
		quit();
	}

}
