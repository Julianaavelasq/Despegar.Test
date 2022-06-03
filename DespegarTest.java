    import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;  
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class DespegarTest {

	@Test(description = "Validar reserva en alojamiento")
		
        public void ValidarReservaAlojamiento()
        
        throws Exception {  
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chome\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.despegar.com.ar/");
		
		WebElement PopUp = driver.findElement(By.xpath("//body"));
		PopUp.click();
		Thread.sleep(1000);
		
		WebElement DespegarHoteles = driver.findElement(By.xpath("//body/nav[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/a[1]/div[1]/i[1]"));    
		Assert.assertTrue(DespegarHoteles.isDisplayed(),"Pagina no encontrada");
		DespegarHoteles.click();
		Thread.sleep(2000);
		
		WebElement Destino = driver.findElement(By.xpath("//body/div[@id='BACKGROUND_MESSAGE']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));    
		Assert.assertTrue(Destino.isDisplayed(),"Pagina no encontrada");
		Destino.click();
		Thread.sleep(2000);
		Destino.sendKeys("Cordoba");
		Thread.sleep(2000);
		Destino.sendKeys(Keys.CONTROL);
		Thread.sleep(2000);
		Destino.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		List<WebElement> Ciudades = driver.findElements(By.xpath("//body/div[5]/div[1]/div[1]/ul[1]/li[1]"));
		WebElement Lugar = Ciudades.get(0);
		Assert.assertTrue(Lugar.isDisplayed(),"Ciudades no encontrada");
		Lugar.click();
		Thread.sleep(2000);
		
		WebElement Fecha = driver.findElement(By.xpath("//body/div[@id='BACKGROUND_MESSAGE']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		Assert.assertTrue(Fecha.isDisplayed(),"Fecha no encontrada");
		Fecha.click();
		Thread.sleep(2000);
		
		WebElement FechaIngreso = driver.findElement(By.xpath("//body/div[@id='component-modals']/div[1]/div[1]/div[2]/div[1]/div[3]/div[17]/div[1]"));
		Assert.assertTrue(FechaIngreso.isDisplayed(),"FechaIngreso no encontrada");
		FechaIngreso.click();
		Thread.sleep(2000);
		
		WebElement FechaSalida = driver.findElement(By.xpath("//body/div[@id='component-modals']/div[1]/div[1]/div[2]/div[1]/div[3]/div[19]/div[1]"));
		Assert.assertTrue(FechaSalida.isDisplayed(),"FechaSalida no encontrada");
		FechaSalida.click();
		Thread.sleep(2000);
		
		WebElement AplicarButton = driver.findElement(By.xpath("//body/div[@id='component-modals']/div[1]/div[2]/div[1]/button[1]/em[1]"));
		Assert.assertTrue(AplicarButton.isDisplayed(),"Boton no encontrado");
		AplicarButton.click();
		Thread.sleep(2000);
		
		WebElement BuscarButton = driver.findElement(By.xpath("//em[contains(text(),'Buscar')]"));
		Assert.assertTrue(BuscarButton.isDisplayed(),"BuscarButton no encontrado");
		BuscarButton.click();
		Thread.sleep(2000);
		
		driver.close();
		
	

	}
	}