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
		wait.until(ExpectedConditions.visibilityOf(DespegarHoteles));
		DespegarHoteles.click();
		
		WebElement Destino = driver.findElement(By.xpath("//div[@id=\"searchbox-sbox-box-hotels\"]//div[@class=\"sbox5-box-places-ovr sbox-places-container--3kBK7\"]"));    
		Assert.assertTrue(Destino.isDisplayed(),"Pagina no encontrada");
		Destino.click();
		wait.until(ExpectedConditions.elementToBeClickable(Destino));
		Destino.sendKeys("Cordoba");
		wait.until(ExpectedConditions.textToBePresentInElement(Destino,"Cordoba"));
		Destino.sendKeys(Keys.CONTROL);
		wait.until(ExpectedConditions.elementToBeClickable(Destino));
		Destino.sendKeys(Keys.ENTER);
		List<WebElement> Ciudades = driver.findElements(By.xpath("//body/div[5]/div[1]/div[1]/ul[1]/li[1]"));
		WebElement Lugar = Ciudades.get(0);
		Assert.assertTrue(Lugar.isDisplayed(),"Ciudades no encontrada");
		Lugar.click();
		wait.until(ExpectedConditions.visibilityOf(Lugar));
		
		WebElement Fecha = driver.findElement(By.xpath("//div[@id=\"searchbox-sbox-box-hotels\"]//div[@class=\"input-containers\"]"));
		Assert.assertTrue(Fecha.isDisplayed(),"Fecha no encontrada");
		wait.until(ExpectedConditions.elementToBeClickable(Fecha));
		Fecha.click();
		
		WebElement FechaIngreso = driver.findElement(By.xpath("//body/div[@id='component-modals']/div[1]/div[1]/div[2]/div[1]/div[3]/div[17]/div[1]"));
		Assert.assertTrue(FechaIngreso.isDisplayed(),"FechaIngreso no encontrada");
		FechaIngreso.click();
		wait.until(ExpectedConditions.elementToBeClickable(FechaIngreso));
		
		WebElement FechaSalida = driver.findElement(By.xpath("//body/div[@id='component-modals']/div[1]/div[1]/div[2]/div[1]/div[3]/div[19]/div[1]"));
		Assert.assertTrue(FechaSalida.isDisplayed(),"FechaSalida no encontrada");
		FechaSalida.click();
		wait.until(ExpectedConditions.elementToBeClickable(FechaSalida));
		
		WebElement AplicarButton = driver.findElement(By.xpath("//body/div[@id='component-modals']/div[1]/div[2]/div[1]/button[1]/em[1]"));
		Assert.assertTrue(AplicarButton.isDisplayed(),"Boton no encontrado");
		AplicarButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(AplicarButton));
		
		WebElement BuscarButton = driver.findElement(By.xpath("//em[contains(text(),'Buscar')]"));
		Assert.assertTrue(BuscarButton.isDisplayed(),"BuscarButton no encontrado");
		BuscarButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(BuscarButton));
		
		driver.close();
		
	}
	}