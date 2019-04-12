package testes;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.Page;

/**
 * @author dpandolfo
 * Classe utilizada para realizar os testes da prova.
 * Como existem pré-condições para o Desafio 2 mantive todos os testes na mesma Classe, incluindo a ordem para execução de forma ascendente. 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DesafioSicredi {

	static WebDriver driver;
	private static DSL dsl;
	private static Page page;
	WebDriverWait wait;
	
	/**
	 * Metodo responsável por inicializar as propriedades do Driver do browser Chrome, mantive na mesma Classe dos testes.
	 * Em um outro cenário acredito que seria ideal instanciar em arquivo properties ou até mesmo separar em outra Classe.
	 */
	@BeforeClass
	public static void inicializa() {
		System.out.println("-------------------------");
		System.out.println(" Inicializando o Driver  ");
		System.out.println("-------------------------");
		
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
		driver.manage().window().maximize();
		dsl = new DSL(driver);
		page = new Page(driver);
	}

	//Iniciando os testes do Desafio 1	
	@Test
	public void desafio1() {
		
		System.out.println("-------------------------");
		System.out.println(" Executando o DESAFIO 1  ");
		System.out.println("-------------------------");
		
		page.setCombo("bootstrap_theme_v4");
		page.addCustomer();
		page.setCustomerName("Teste Sicredi");
		page.setContactLastName("Teste");
		page.setContactFirstName("Diego");
		page.setPhone("51 9999-9999");
		page.setAddressLine1("Av Assis Brasil, 3970");
		page.setAddressLine2("Torre D");
		page.setCity("Porto Alegre");
		page.setState("RS");
		page.setPostalCode("91000-000");
		page.setCountry("Brasil");
		page.setFromEmployeer("Fixter");
		page.sendTabKeyFromEmployeer();
		page.setCreditLimit("200");
		page.clickSave();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Realizando validação da mensagem exibida após salvar o formulário
		Assert.assertTrue("Your data has been successfully stored into the database.",
				driver.findElement(By.xpath("//*[@id='report-success']/p")).getText()
						.startsWith("Your data has been successfully stored into the database"));
	}
	
	//Iniciando os testes do Desafio 2
	@Test
	public void desafio2() throws InterruptedException {
		
		System.out.println("------------------------");
		System.out.println(" Executando o DESAFIO 2 ");
		System.out.println("------------------------");
		
		page.clickReturn();
		page.clickSearch();
		page.searchText("Teste Sicredi");
		page.sendTabKeySearchText();
		
		Thread.sleep(1000);
		
		page.clickCheckBoxActions();
		page.clickDeleteAction();
		
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-dialog")));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Realizando validação da mensagem exibida no alerta de confirmação de exclusão
		Assert.assertEquals("Are you sure that you want to delete this 1 item?", 
    			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]")).getText());
		dsl.clickElementByCss(".delete-multiple-confirmation-button");
		
		Thread.sleep(1000);
		
		//Realizando validação da mensagem exibida após deletar o registro encontrado
		Assert.assertEquals("Your data has been successfully deleted from the database.", 
    			driver.findElement(By.xpath("//div[@data-growl='container']/span[@data-growl='message']")).getText());
	}
	
	//Realizando a finalização do Driver, neste momento fecha o navegador e tambem no executavel do Driver
	@AfterClass
	public static void finaliza() {
		System.out.println("------------------------");
		System.out.println(" Finalizando o Driver   ");
		System.out.println("------------------------");
		driver.quit();
	}
}
