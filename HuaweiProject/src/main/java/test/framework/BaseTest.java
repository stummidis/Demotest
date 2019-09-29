package test.framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class BaseTest {
	public WebDriver driver;
	public WebDriver openBrowser(String browserType) {
		

		if (browserType.equals("Mozilla")) {
			
			String path1 = System.getProperty("user.dir") + "\\Lib\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", path1);
			driver = new FirefoxDriver();
		}
		else if (browserType.equals("Chrome")) {

			String path2 = System.getProperty("user.dir") + "\\Lib\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path2);
			driver = new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public void navigate(WebDriver driver, String URLKey) {
		
		driver.get(URLKey);
	}
	public void searchtext(String text){
		
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys(text);
		driver.findElement(By.xpath("//*[@id='nav-search']/form/div[2]/div")).click();
	}
	public void sortresult(String result){
		
		driver.findElement(By.xpath("//*[@id='a-autoid-0-announce']")).click();
		List <WebElement> li = driver.findElements(By.xpath("//li/*[@class='a-dropdown-link']"));
		String result1 = "Price: "+result;
		if(result1.equalsIgnoreCase("Price: Low to High")){
			li.get(0).click();
		}else if(result1.equalsIgnoreCase("Price: High to Low")){
			
			li.get(1).click();
		}			

	}
	public void select_product_link_and_verify_text(int x, String giventext){
		
		List<WebElement> productList = driver.findElements(By.xpath("//*[@class='a-link-normal a-text-normal']"));
		
		
		/**
		for(int i =0; i<productList.size(); i++){
			System.out.println(productList.get(i).getText());			
		}
		*/
		productList.get(x).click();
		
		String pTitle=driver.findElement(By.xpath("//*[@id='title']")).getText();		
		String str1[] = pTitle.split(" ");
		String webtxt =str1[0]+" "+ str1[1];
		System.out.println(webtxt);
		
		Assert.assertEquals(webtxt, giventext);
		/**
		if(giventext.equals(webtxt)){
			System.out.println("user can see the given product");
		}else{
			System.out.println("please select another link");
		}
		**/
		
	}
	
	public void quit(){
		driver.quit();
	}

	

}
