package testCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ComboBoxEditor;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoForSap {
	static WiniumDriver driver=null;
	static WiniumDriverService service=null;
	static DesktopOptions options=null;
	
	@BeforeClass
	public static  void setupEnvironment() throws IOException {
		 
	    options = new DesktopOptions(); //Initiate Winium Desktop Options
	    options.setApplicationPath("C:\\Program Files (x86)\\SAP\\FrontEnd\\SAPgui\\saplogon.exe"); //Set outlook application path
	 
	    File drivePath = new File("D:\\PJ\\Winium\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe"); //Set winium driver path
	 
	    service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
	    service.start(); //Build and Start a Winium Driver service
	    driver = new WiniumDriver(service, options); //Start a winium driver
	 
	   
	 
	}
	/*@AfterClass
	public void closeApplication() throws IOException
	{
		Runtime.getRuntime().exec("taskkill /F /IM saplogon.exe");
	}*/
    @Test
	public void selectElement() throws MalformedURLException, InterruptedException, AWTException {

        Thread.sleep(1000);
        driver.findElement(By.name("Variable Logon...")).click();
        Thread.sleep(2000);
        Actions act=new Actions(driver);
        Robot robot = new Robot();
        driver.findElement(By.name("Next >")).click();
        robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);robot.keyRelease(KeyEvent.VK_TAB);
        //driver.findElement(By.name("Connection Type:")).sendKeys("name");
         
        	WebElement myComboBox = driver.findElement(By.id("8107")); 
        	ComboBox c1 = new ComboBox(myComboBox); 
        	c1.expand(); 
        	driver.findElement(By.name("Group/Server Selection")).click(); 
        	
        	 

       
     /*   ComboBox CBObj=new ComboBox(driver.findElement(By.name("Connection Type:")));
        CBObj.scrollTo(By.id("1"));*/
     /*   Select select =new Select(driver.findElement(By.name("Connection Type:")));
       select.selectByIndex(1);
     */   
       // driver.findElement(By.id("8070")).click();
        robot.keyPress(KeyEvent.VK_TAB);
      // robot.keyPress(KeyEvent.VK_TAB);
        driver.findElement(By.name("Application Server:")).sendKeys("name");
       // act.moveToElement(driver.findElement(By.name("Instance Number:"))).click().perform();
        //driver.findElement(By.name("Application Server:")).sendKeys(Keys.TAB);
       
      
        robot.keyPress(KeyEvent.VK_TAB);
        driver.findElement(By.name("Instance Number:")).sendKeys("1234");
        robot.keyPress(KeyEvent.VK_TAB);
        driver.findElement(By.name("System ID:")).sendKeys("id");
        robot.keyPress(KeyEvent.VK_TAB);
        driver.findElement(By.name("SAProuter String:")).sendKeys("string");
        
        driver.findElement(By.name("< Back")).click();
	}

}
