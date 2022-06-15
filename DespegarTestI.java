import org.openqa.selenium.WebDriver;  
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.ITestContext;
import com.selenium.driver.DriverFactory;
import com.selenium.pages.DespegarTestPage;


public class DespegarTestI<DespegarHoteles> extends DriverFactory 
{
	DespegarTestPage Home;
	WebDriver driver;
	
	@BeforeMethod 
	public void setUp(ITestContext contex) 
	{	
    String url = context.getCurrentXmlTest().getParameter("UrlDespegar");
	WebDriver driver = DriverFactory.LevantarBrowser(driver,"CHROME","https://www.despegar.com.ar/");	
	Home = new DespegarTestPage(driver);
	}
	
	@DataProvider (name = "DataProviderCiudades")
	public Object[][] dpMethod() 
	{
		return new Object[][] {{"Cordoba"},{"Salta"},{"Entre Rios"}};
}
	@Test (groups = {"DespegarTestI"}, dataProvider = "DataProviderDespegar")
	public void ValidarReservaAlojamiento(String dataProviderDespegar) throws Exception 
	{
    Home.DespegarHoteles();
    Home.Destino(dataProviderDespegar);
    Home.Fecha();
    Home.FechaIngreso();
    Home.Fecha1();
    Home.FechaSalida();
	Home.AplicarButton();
	Home.BuscarButton();
	}
	@AfterMethod
	public void FinalizarTest()
	{
		driver.close();
	}
	}

