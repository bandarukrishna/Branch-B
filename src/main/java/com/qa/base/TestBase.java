package com.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	//***************@@@@@@********************
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;	
	public TestBase(){
		try {		                  
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization()  {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\krishna\\eclipse-workspace1\\Cucumber\\src\\test\\resources\\Drivers\\chromedriver.exe");	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			//WebDriverManager.phantomjs().setup();
			//	
			//driver = new PhantomJSDriver();
		
		//	DesiredCapabilities dr=DesiredCapabilities.chrome();
	       // dr.setBrowserName("chrome");
	      //  dr.setPlatform(Platform.LINUX);
	      //   driver=new RemoteWebDriver(new    URL("http://192.168.0.106:4444/wd/hub"), dr);
		}
		else if(browserName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
			//Selenium s=new WebDriverBackedSelenium(driver,"xyz");
			
		}
		else {
			 driver = new HtmlUnitDriver();
		}
		
		/*
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void initialization(String mailurl, String browName)  {
		
		if(browName.equals("chrome")){
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		else if(browName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
			
		}
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(mailurl);
		
	}
	
	public static void close_browser()
	{
		driver.quit();
	}


	public static String getReportConfigPath(){
		//System.out.println("Path"  +System.getProperty("user.dir")+prop.getProperty("reportConfigPath"));
		String reportConfigPath =System.getProperty("user.dir")+"/src/main/resources/extent-config.xml"; //System.getProperty("user.dir")+prop.getProperty("reportConfigPath");
				return reportConfigPath;		
	}
	
	public static  String GetCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat(
	            "yyyy-MM-dd HH:mm:ss.SSS");// dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}	

}
