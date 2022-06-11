package com.selenium.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;


public class DespegarTestPage
{
	WebDriver driver= null;
	WebDriverWait wait = null;
	
	@FindBy(xpath ="//body/nav[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/a[1]/div[1]/i[1]")
	private WebElement DespegarHoteles;
	@FindBy(css ="div#searchbox-sbox-box-hotels div.sbox-places-destination--1xd0k input" )
	private WebElement Destino;
	@FindBy(css ="div.ac-wrapper.-show>div>div>ul>li")
	private List<WebElement> Ciudades;
	@FindBy(css ="div.ac-wrapper.-show>div>div>ul>li")
	private WebElement Lugar;
	@FindBy(css ="div#searchbox-sbox-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input1")
	private WebElement Fecha;
	@FindBy(css ="div.sbox5-floating-tooltip-opened div.calendar-container div.-today")
	private WebElement FechaIngreso;
    @FindBy(css ="div#searchbox-sbox-box-box-hotels div.sbox5-box-dates-checkbox-container div.sbox5-dates-input2")
	private WebElement Fecha1;
	@FindBy(css ="div.sbox5-floating-tooltip-opened div.calendar-container div.-selected + div")
	private WebElement FechaSalida;
	@FindBy(css ="div.sbox5-floating-tooltip-opened div.calendar-footer em.btn-text")
	private WebElement AplicarButton;
	@FindBy(css ="div#searchbox-sbox-box-hotels button")
	private WebElement BuscarButton;
	
	
	public DespegarTestPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}

	
	public void DespegarHoteles() {
	    DespegarHoteles.click();
	}
	public void Destino(String Text) throws Exception{
		wait.until(ExpectedConditions.elementToBeClickable(Destino));
		Destino.click();
		Destino.sendKeys(Text);
		Thread.sleep(1000);
		Destino.sendKeys(Keys.CONTROL);
		wait.until(ExpectedConditions.elementToBeClickable(Lugar));
		Destino.sendKeys(Keys.ENTER);
		}
	public void Fecha() {
		Fecha.click();
		wait.until(ExpectedConditions.visibilityOf(FechaIngreso));
	}
	public void FechaIngreso() {
		FechaIngreso.click();
		wait.until(ExpectedConditions.elementToBeClickable(FechaIngreso));
	}	
	public void Fecha1() {
		Fecha1.click();
		wait.until(ExpectedConditions.visibilityOf(FechaSalida));
	}
	public void FechaSalida() {
		FechaSalida.click();
		wait.until(ExpectedConditions.elementToBeClickable(FechaSalida));
	}
	public void AplicarButton() {
		AplicarButton.click();
		wait.until(ExpectedConditions.visibilityOf(BuscarButton));
	}
	public void BuscarButton() {
		BuscarButton.click();
	}
	}
	

