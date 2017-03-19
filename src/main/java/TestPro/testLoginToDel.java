package TestPro;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class testLoginToDel {
	
	  private static WebDriver driver;
	  private String baseUrl;
	  private String pathFile;
	  
	  String uuid = null;
	  String name = null;
	  
	  private Actions action = null;
 
	  @BeforeClass
	  public void setUp() throws Exception {
		System.setProperty("WebDriver.ie.driver",
				"C:\\Windows\\System32\\IEDriverServer.exe");
	    driver = new InternetExplorerDriver();	    
	    baseUrl = "http://127.0.0.1:8040";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    //创建一个action实例，用于调用其内部的方法
	    action = new Actions(driver);
	    //用户名+随机数
	    uuid = Common.getUserName("uuid", 1000);		    
	    //姓名+随机数
	    name = Common.getUserName("name",1000);
	  }

	  
	  @Test	  
	  public void Case1() throws Exception {		  	
		    //登录
		    Actions.login(baseUrl); 		    
		  }
	  
	  @Test	  
	  public void Case2() throws Exception {		  	
		    //增加一个人员
		    Actions.addMen(uuid,name); 		    
		  }
	  
	  @Test	  
	  public void Case3() throws Exception {		  	
		    //查询是否增加成功
		    Actions.Query(uuid,name); 		    
		  }
	  
	  @Test	  
	  public void Case4() throws Exception {		  	
		    //删除一个人员
		    Actions.delMen(uuid);   		    
		  }



	  @AfterClass
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
	  
	  
	    
	    

}
