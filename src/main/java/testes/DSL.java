package testes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author dpandolfo
 * Classe responsável por métodos mais descritivos para facilitar a iteração com os métodos do Selenium, centralizando a forma de execução.
 *
 */
public class DSL {

	WebDriver driver;
	WebDriverWait wait;
		
    public DSL(WebDriver driver) {
    	this.driver = driver;	
    }

	public void selectComboById(String id_campo, String valor){
    	new Select(driver.findElement(By.id(id_campo))).selectByValue(valor);
        return;
    }
    
	public void clickElementByClassName(String id_campo){
		driver.findElement(By.className(id_campo)).click();
    }
	
	public void writeFieldById(String id_campo, String texto){
		driver.findElement(By.id(id_campo)).sendKeys(texto);
    }

	public void writeFieldByXpath(String id_campo, String texto){
		driver.findElement(By.xpath(id_campo)).sendKeys(texto);
    }
	
	public void sendTabElementByXpath(String id_campo){
		driver.findElement(By.xpath(id_campo)).sendKeys(Keys.TAB);
    }
	
	public void sendTabElementByClassName(String id_campo){
		driver.findElement(By.className(id_campo)).sendKeys(Keys.TAB);
    }
	
	public void writeFieldByClassName(String id_campo, String texto){
		driver.findElement(By.className(id_campo)).sendKeys(texto);
    }
	
	public void clickElementById(String id_campo){
		driver.findElement(By.id(id_campo)).click();
    }
	
	public void clickElementByLinkText(String id_campo){
		driver.findElement(By.linkText(id_campo)).click();
    }
	
	public void clickElementByCss(String id_campo){
		driver.findElement(By.cssSelector(id_campo)).click();
    }
}
