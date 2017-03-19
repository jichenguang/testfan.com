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
     * �������Աά����
     * @author Simba
     * �л���Ԫ������ franme
     * ������frame��name���ԣ������ظ�����ʱ�Ҳ���frame
     * ����л���Ĭ�� ��frame
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
     * �����������Աά����
     * @author Simba
     * @throws InterruptedException 
     * 
     */
    public static void addMen(String uuid,String name) throws InterruptedException{

    driver.switchTo().frame("main");		    
    driver.findElement(By.name("record_record_addRecord")).click();
    
    /**
     * 
     * �л��������
     * @author Simba		    
     */
    Common.mySwitchWindow(driver);	
    
    /**
     * ������Ա
     * @author Simba
     */		    

    driver.findElement(By.name("record:useruuid")).sendKeys(uuid);
    driver.findElement(By.name("record:name")).sendKeys(name);
    Thread.sleep(3000);
    //���벿��
    driver.findElement(By.name("record:department")).sendKeys("����ս��");
    //���ѡ���ɫ
    Common.getSelect("record:roleuuid",3,driver);
    //���ѡ����
    Common.getSelect("record:ability",5,driver);
    //����
    driver.findElement(By.name("record_record_saveAndExit")).click();
    //�л���Ĭ�Ͼ��
    Common.mySwitchWindow(driver);
    //�л���Ĭ��frame
    driver.switchTo().frame("main");	
    }
  
  
  
  
    /**
     * ��ѯ�Ƿ����ӳɹ�
     * @author Simba
     * 
     */
    public static boolean Query(String uuid,String name){

	    driver.findElement(By.name("select-key:useruuid")).sendKeys(uuid);
	    driver.findElement(By.name("select-key_submit")).click();	
		 
		   /**
		     * ������ѯ�����Ȼ��ѡȡ�����text�������û������Ƚϣ�������֤����ӳɹ���
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
	    		System.out.println("����"+name+"��ѯ�ɹ���");
	    		break;
	    	}else{
	    		System.out.println("����"+name+"û��ѯ����");
	    		return false;
	    	}
	    }
		return true;	   
    }
  
    /**
     * ���ܱ���ɾ��һ��ѡ��
     * @author Simba
     * @throws InterruptedException 
     */
    
    public static boolean delMen(String uuid) throws InterruptedException{
    List<WebElement> trs2 = driver.findElement(By.id("record"))
    		.findElements(By.tagName("tr"));
    for(WebElement tr:trs2){
    	Thread.sleep(3000);
    	if(tr.getAttribute("class").equals("grid-headrow")){
    		System.out.println("����ѡ���б��һ��");
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
    				System.out.println("ɾ���û�"+uuid+"���ɹ���");
    			}else{
    				System.out.println("ɾ���û�"+uuid+"�ɹ���");
    				break;
    			}
    		}
    	}
    }
	return true;
    } 
    
}
