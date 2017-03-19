package SelectByCss;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class SelectByCssForGetLinks {
	
	
	private InternetExplorerDriver driver;
	private String baseUrl;



	@Test
	public void getLinks() throws InterruptedException {
	   driver.get(baseUrl);
	   
	   //先找到课程的DIV，然后 按照CSS属性查找课程名称
	   WebElement courseBase = driver.findElement(By.id("hayanana"));	   
	   List<WebElement>  Courses = courseBase.findElements(By.cssSelector("h4[class='wqd-text-title4']"));
	   
	   System.out.println("课程一共有："+Courses.size()+"门:");
	   for(WebElement course:Courses){
		   //获取课程名称
		   String courseName = course.getText();
		   System.out.println("********");
		   System.out.println("课程的名称是："+courseName);
		   System.out.println("********");
		  	
		   Thread.sleep(1000);
		   course.click();
		   //切换到课程详情页，可以自动返回默认页
		   mySwitchWindow(driver);

   
	   }
	}
  
  
  @BeforeMethod
  public void beforeMethod() {	  
	  System.setProperty("WebDriver.ie.driver",
				"C:\\Windows\\System32\\IEDriverServer.exe");
	    driver = new InternetExplorerDriver();
//	    driver = new FirefoxDriver();
	    baseUrl = "http://www.testfan.cn/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  
  /**
   * 处理SwitchWindow();
   * @author Simba
 * @throws InterruptedException 
   */
   static void mySwitchWindow(WebDriver driver) throws InterruptedException {
	// TODO Auto-generated method stub
	
	/*一次遍历不到，多循环几次*/
	for(int i = 0;i<10;i++){
		  String currentWindow  = driver.getWindowHandle();
		  Set handles = driver.getWindowHandles();
		  
		  Iterator<String> it = handles.iterator();

		  while(it.hasNext()){
			  String handle = it.next();
			  if (currentWindow.equals(handle)){
				  continue; //跳出当前循环
			  }else{
				  WebDriver window = driver.switchTo().window(handle);
				  System.out.println("2"+window.getTitle());
				  //切换回默认的句柄
				  window.switchTo().defaultContent();
				   
			  }
		  }
	  } 
	   

			  
}

}
