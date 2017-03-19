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
	    
	    //����һ��actionʵ�������ڵ������ڲ��ķ���
	    action = new Actions(driver);
	    //�û���+�����
	    uuid = Common.getUserName("uuid", 1000);		    
	    //����+�����
	    name = Common.getUserName("name",1000);
	  }

	  
	  @Test	  
	  public void Case1() throws Exception {		  	
		    //��¼
		    Actions.login(baseUrl); 		    
		  }
	  
	  @Test	  
	  public void Case2() throws Exception {		  	
		    //����һ����Ա
		    Actions.addMen(uuid,name); 		    
		  }
	  
	  @Test	  
	  public void Case3() throws Exception {		  	
		    //��ѯ�Ƿ����ӳɹ�
		    Actions.Query(uuid,name); 		    
		  }
	  
	  @Test	  
	  public void Case4() throws Exception {		  	
		    //ɾ��һ����Ա
		    Actions.delMen(uuid);   		    
		  }



	  @AfterClass
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
	  
	  
	    
	    

}
