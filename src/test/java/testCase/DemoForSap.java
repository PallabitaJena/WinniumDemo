package testCase;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class SapLogOn {


	
		static WiniumDriver driver=null;
		static WiniumDriverService service=null;
		static DesktopOptions options=null;
		public static Properties prop;
		
		@BeforeClass
		public static  void setupEnvironment() throws IOException {
			
		    options = new DesktopOptions(); //Initiate Winium Desktop Options
		    options.setApplicationPath("C:\\Program Files (x86)\\SAP\\FrontEnd\\SAPgui\\saplogon.exe");  //Set Sap application path
		    
		    File drivePath = new File("C:\\Users\\pallabita.jena\\Desktop\\SAP\\Winium.Desktop.Driver\\Winium.Desktop.Driver.exe"); //Set winium driver path
		 
		    service = new WiniumDriverService.Builder().usingDriverExecutable(drivePath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
		    service.start(); //Build and Start a Winium Driver service
		    driver = new WiniumDriver(service, options); //Start a winium driver
		    InitializeProp();
		   
		 
		}
		/*@AfterClass
		public void closeApplication() throws IOException
		{
			Runtime.getRuntime().exec("taskkill /F /IM saplogon.exe");
		}*/
		
		public static void InitializeProp() throws IOException
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\rudra_rath\\Desktop\\Workspace\\fstDemo\\src\\main\\java\\sapLogOn\\config.properties");
			prop.load(ip);
		}
	    @Test
		public void preLogIn() throws MalformedURLException, InterruptedException, AWTException
	    {

	        Thread.sleep(1000);
	        driver.findElement(By.name("Variable Logon...")).click();
	        Thread.sleep(2000);
	        Robot robot = new Robot();
	        
	       driver.findElement(By.name("Next >")).click();
	       driver.findElement(By.name("Application Server:")).sendKeys(prop.getProperty("App_server"));
	       robot.keyPress(KeyEvent.VK_TAB);
	        driver.findElement(By.name("Instance Number:")).sendKeys(prop.getProperty("Instance_Number"));
	        robot.keyPress(KeyEvent.VK_TAB);
	        driver.findElement(By.name("System ID:")).sendKeys(prop.getProperty("System_ID"));
	        driver.findElement(By.name("Log On")).click();
	        ///on login  window:///
	       
	        
	        
	       }
	    @Test
	    public void logIN() throws AWTException, InterruptedException
	    {
	    	Robot robot = new Robot();
	    	 Thread.sleep(2000);
		        WebElement newWindow = driver.findElement(By.name("SAP"));
		        Thread.sleep(2000);
		        String newWindowHandle = newWindow.getAttribute("NativeWindowHandle");
		        Thread.sleep(2000);
		       
		        driver.switchTo().window(newWindowHandle);
		        
		        driver.findElement(By.id("100")).sendKeys(prop.getProperty("logInId"));
		        robot.keyPress(KeyEvent.VK_TAB);
		        driver.findElement(By.id("100")).sendKeys(prop.getProperty("Password"));
		        
		        robot.keyPress(KeyEvent.VK_ENTER);robot.keyRelease(KeyEvent.VK_ENTER);
		        
		        ////After login:///
		        Thread.sleep(4000);
		        driver.findElement(By.id("1001")).sendKeys(prop.getProperty("Execute_Transaction"));
		        robot.keyPress(KeyEvent.VK_ENTER);robot.keyRelease(KeyEvent.VK_ENTER);
		        
	    }
	    @Test
	    public void enteringData()
	    {
	    	
	    }
	    
	    

	}
