    import java.util.List;
    import org.openqa.selenium.By;
    import org.openqa.selenium.Keys;
    import org.openqa.selenium.WebDriver;  
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class DespegarTest {

	@Test(description = "Validar reserva en alojamiento")
		
        public void ValidarReservaAlojamiento()
        
        throws Exception {  
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chome\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.despegar.com.ar/");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		WebElement DespegarHoteles = driver.findElement(By.xpath("//body/nav[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/a[1]/div[1]/i[1]"));    
		Assert.assertTrue(DespegarHoteles.isDisplayed(),"Pagina no encontrada");
		DespegarHoteles.click();
		
		WebElement Destino = driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox-places-destination--1xd0k input"));    
		Assert.assertTrue(Destino.isDisplayed(),"Pagina no encontrada");
		Destino.click();
		Destino.sendKeys("Cordoba");
		Thread.sleep(1000);
		Destino.sendKeys(Keys.CONTROL);
		Thread.sleep(1000);
		Destino.sendKeys(Keys.ENTER);
		List<WebElement> Ciudades = driver.findElements(By.cssSelector("div.ac-wrapper.-show>div>div>ul>li"));
		WebElement Lugar = Ciudades.get(0);
		Assert.assertTrue(Lugar.isDisplayed(),"Ciudades no encontrada");
		Lugar.click();
		wait.until(ExpectedConditions.elementToBeClickable(Lugar));
		
		WebElement Fecha = driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1"));
		Assert.assertTrue(Fecha.isDisplayed(),"Fecha no encontrada");
		wait.until(ExpectedConditions.elementToBeClickable(Fecha));
		Fecha.click();
		
		WebElement FechaIngreso = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-today"));
		Assert.assertTrue(FechaIngreso.isDisplayed(),"FechaIngreso no encontrada");
		FechaIngreso.click();
		wait.until(ExpectedConditions.elementToBeClickable(FechaIngreso));
		
		WebElement Fecha1 = driver.findElement(By.cssSelector("div#searchbox-sbox-box-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input2"));
		Assert.assertTrue(Fecha1.isDisplayed(),"Fecha1 no encontrada");
		Fecha1.click();
		wait.until(ExpectedConditions.elementToBeClickable(Fecha1));
		
		WebElement FechaSalida = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-container div.-selected + div"));
		Assert.assertTrue(FechaSalida.isDisplayed(),"FechaSalida no encontrada");
		FechaSalida.click();
		wait.until(ExpectedConditions.elementToBeClickable(FechaSalida));
		
		WebElement AplicarButton = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.calendar-footer em.btn-text"));
		Assert.assertTrue(AplicarButton.isDisplayed(),"Boton no encontrado");
		AplicarButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(AplicarButton));
		
		WebElement BuscarButton = driver.findElement(By.cssSelector("div#searchbox-sbox-box-hotels button"));
		Assert.assertTrue(BuscarButton.isDisplayed(),"BuscarButton no encontrado");
		BuscarButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(BuscarButton));
		
		driver.close();
		
	}
	}