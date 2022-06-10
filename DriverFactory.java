package com.selenium.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class DriverFactory {

	private enum Browsers {
		FIREFOX, CHROME
		
	}
	
	public static WebDriver LevantarBrowser (WebDriver driver, String browserName, String url)
	{
		
		switch(Browsers.valueOf(browserName)) 
		{
		
		case CHROME:
			
			System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Chome\\\\chromedriver.exe");
			Reporter.log("Abrir Navegador Chome");
			driver = new ChromeDriver();
			break;
			
		case FIREFOX:
			
			System.setProperty("webdriver.firefox.driver", "C:\\Program Files\\Firefox\\geckodriver");
			Reporter.log("Abrir Navegador Firefox");
			driver = new FirefoxDriver();
			break;
		
		default:
		Reporter.log("No se selecciono un navegador correcto, se abre Chome por defecto");
		System.setProperty("webdriver.chrome.driver","C:\\\\Program Files\\\\Chome\\\\chromedriver.exe");
		Reporter.log("Abrir Navegador Chome");
		driver = new ChromeDriver();
		break;
		}
		return driver;
	}
}
	
	
