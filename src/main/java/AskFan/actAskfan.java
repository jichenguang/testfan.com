package AskFan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class actAskfan {
	
	  private static WebDriver driver;
	  private String baseUrl;
	  private String pathFile;
	  
	  

 
	  @BeforeClass
	  public void setUp() throws Exception {
		System.setProperty("WebDriver.ie.driver",
				"C:\\Windows\\System32\\IEDriverServer.exe");
//	    driver = new InternetExplorerDriver();
	    driver = new FirefoxDriver();
	    baseUrl = "http://ask.testfan.cn/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    

	  }

	  
	  @Test	  
	  public void Case1() throws Exception {		  	
		    
		  driver.get(baseUrl);
		  driver.findElement(By.xpath(".//*[@id='global-navbar']/ul[2]/li[1]/a")).click();
		  driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[1]/input")).sendKeys("45462001@qq.com");
		  driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input")).sendKeys("testfan");
		  driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[3]/button")).click();

		  System.out.println(driver
				  .findElement(By.xpath(".//*[@id='global-navbar']/ul[2]/li[3]/a/span"))
				  .getText());
		  
		  driver.findElement(By.xpath(".//*[@id='searchBox']")).clear();
		  driver.findElement(By.xpath(".//*[@id='searchBox']")).sendKeys("JiChenguang");
		  driver.findElement(By.xpath(".//*[@id='search-button']")).click();
		  driver.findElement(By.xpath("html/body/div[3]/div/div/div[2]/div[1]/section/h2/a/em")).getText();
		  String testResult =  driver.findElement(By
				  .xpath("html/body/div[3]/div/div/div[2]/div[1]/section/h2/a/em")).getText();
		  String exRes = "JiChenguang";

		  if(testResult.equals(exRes)){
			  System.out.println("找到用户");
		  }
		  
		  }
	  		

	  

	  @AfterClass
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
	  
	  
	    
	    

}
