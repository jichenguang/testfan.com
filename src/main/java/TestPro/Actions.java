package TestPro;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions {
	static WebDriver driver = null;
	
	public Actions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
		
	
	/**
     * 点击“人员维护”
     * @author Simba
     * 切换到元素所在 franme
     * 尽量用frame的name属性，避免重复运行时找不到frame
     * 最后切换回默认 的frame
     */
	public static void login(String baseUrl){
	    driver.get(baseUrl);
	    driver.findElement(By.id("imageField")).click(); 
	    driver.switchTo().frame("code");
	    	    
	    WebElement testTable = driver.findElement(By.id("menu"));
	    testTable.findElements(By.tagName("tr")).get(2)
	    .findElement(By.tagName("td"))
	    .findElement(By.tagName("span"))
	    .findElement(By.tagName("span"))
	    .click();		    
	    driver.switchTo().defaultContent();
	}  
	
    /**
     * 点击“增加人员维护”
     * @author Simba
     * @throws InterruptedException 
     * 
     */
    public static void addMen(String uuid,String name) throws InterruptedException{

    driver.switchTo().frame("main");		    
    driver.findElement(By.name("record_record_addRecord")).click();
    
    /**
     * 
     * 切换弹窗句柄
     * @author Simba		    
     */
    Common.mySwitchWindow(driver);	
    
    /**
     * 新增人员
     * @author Simba
     */		    

    driver.findElement(By.name("record:useruuid")).sendKeys(uuid);
    driver.findElement(By.name("record:name")).sendKeys(name);
    Thread.sleep(3000);
    //输入部门
    driver.findElement(By.name("record:department")).sendKeys("银河战队");
    //随机选择角色
    Common.getSelect("record:roleuuid",3,driver);
    //随机选择技能
    Common.getSelect("record:ability",5,driver);
    //保存
    driver.findElement(By.name("record_record_saveAndExit")).click();
    //切换回默认句柄
    Common.mySwitchWindow(driver);
    //切换回默认frame
    driver.switchTo().frame("main");	
    }
  
  
  
  
    /**
     * 查询是否增加成功
     * @author Simba
     * 
     */
    public static boolean Query(String uuid,String name){

	    driver.findElement(By.name("select-key:useruuid")).sendKeys(uuid);
	    driver.findElement(By.name("select-key_submit")).click();	
		 
		   /**
		     * 遍历查询结果，然后选取结果的text与新增用户名作比较，符合则证明添加成功。
		     * 
		     */
	    List<WebElement> trs = driver
	    		.findElement(By.id("record"))
	    		.findElements(By.tagName("tr"));
	    
	    for(int m = 1;m<trs.size();m++){
	    	String queryStr = trs.get(m)
	    		.findElement(By.id("span_record:useruuid"))
	    		.getText();
	    	
	    	if(queryStr!=null&&queryStr.equals(uuid)){
	    		System.out.println("新人"+name+"查询成功！");
	    		break;
	    	}else{
	    		System.out.println("新人"+name+"没查询到！");
	    		return false;
	    	}
	    }
		return true;	   
    }
  
    /**
     * 从总表中删除一个选项
     * @author Simba
     * @throws InterruptedException 
     */
    
    public static boolean delMen(String uuid) throws InterruptedException{
    List<WebElement> trs2 = driver.findElement(By.id("record"))
    		.findElements(By.tagName("tr"));
    for(WebElement tr:trs2){
    	Thread.sleep(3000);
    	if(tr.getAttribute("class").equals("grid-headrow")){
    		System.out.println("不能选择列表第一行");
    	}else{
    		List<WebElement> tds2 = tr.findElements(By.tagName("td"));
    		WebElement checkbox = tds2.get(0);
    		WebElement checkUid = tds2.get(1).findElement(By.tagName("span"));
    		if(checkbox.isEnabled()&&checkUid.getText().equals(uuid)){
    			Thread.sleep(3000);
    			checkbox.click();
    			driver.findElement(By.name("record_record_deleteRecord")).click();
    			Alert alt = driver.switchTo().alert();    			
    			System.out.println(alt.getText());
    			alt.accept();
    			
    			Thread.sleep(3000);
    			Alert alt2 = driver.switchTo().alert();   			
    			System.out.println(alt2.getText());
    			alt2.accept();
    			if(checkUid.equals(uuid)){
    				System.out.println("删除用户"+uuid+"不成功！");
    			}else{
    				System.out.println("删除用户"+uuid+"成功！");
    				break;
    			}
    		}
    	}
    }
	return true;
    } 
    
}
