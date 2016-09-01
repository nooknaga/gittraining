package TestData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import TestData.ReadTestProperties;
import PageFactory.LoginPage;

import org.openqa.selenium.support.*;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;


public class DriverSetup {

	
	static WebDriver oBrowser;
	public static LoginPage SelectBrowser() throws Exception
	{
		//WebDriver oBrowser;
		
		String browserType = ReadTestProperties.getProperty("browserType"); 
		String sURL = ReadTestProperties.getProperty("url");
		browserType = browserType.trim().toUpperCase();
		
		
		switch(browserType)
		{
		case "IE" :
			System.setProperty("webdriver.ie.driver", "D:\\Preparation\\SeleniumAutomation\\IEDriver\\IEDriverServer.exe");
			oBrowser = new InternetExplorerDriver();
			oBrowser.manage().deleteAllCookies();
			break;
			
		case "CHROME" :
			System.setProperty("webdriver.chrome.driver", "D:/Preparation/SeleniumAutomation/ChromeDriver/chromedriver.exe");
			oBrowser = new ChromeDriver();
			oBrowser.manage().deleteAllCookies();
			break;
			
		case "HTMLUNIT" :
			oBrowser = new HtmlUnitDriver();
			break;
			
		default :
			oBrowser =  new FirefoxDriver();
			oBrowser.manage().deleteAllCookies();
			break;			
		}
		
		oBrowser.manage().window().maximize();
		oBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		oBrowser.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		oBrowser.navigate().to(sURL);
		//Thread.sleep(30000);
		LoginPage login = new LoginPage(oBrowser);
		//PageFactory.initElements(oBrowser, login);
		return login;
	}
}
