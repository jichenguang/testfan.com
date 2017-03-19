package TestPro;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Common {

	  
	  /**
	   * 处理select选择框
	   * @author Simba   
	   * */
	  public static void getSelect(String idpath,int num,WebDriver driver){
		  Select sel = new Select(driver.findElement(By.id(idpath)));
		  sel.selectByIndex(getRadomNum(num));
	  }

	  
	  
	  /**
	   * 处理SwitchWindow();
	   * @author Simba
	   */
	   static void mySwitchWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		  String currentWindow = driver.getWindowHandle();
		  Set handles = driver.getWindowHandles();
		  Iterator<String> it = handles.iterator();
		  while(it.hasNext()){
			  String handle = it.next();
			  if (currentWindow.equals(handle)){
				  continue; //跳出当前循环
			  }else{
				  WebDriver window = driver.switchTo().window(handle);
				  System.out.println(window.getTitle());
			  }
		  }
				  
	}


	   /**
	    * 随机用户名和随机姓名
	    * @param str
	    * @return
	    */
	    public static String getUserName(String str,int max){
			String FirstName = str;
	    	String UserName = "";
	    		    	
	    	UserName = FirstName + getRadomNum(max);
	    	return UserName;	    	
	    }
	    
	   /**
	    * 封装随机数 
	    * @param max
	    * @return
	    */
	    public static int getRadomNum(int max){
	    	
			int num = 0;
	    	Random RadomNum = new Random();
	    	for(int i = 1;i<=max;i++){
	    		num = RadomNum.nextInt(max)+1;
	    	}	
	    	return num;
	    }

}
