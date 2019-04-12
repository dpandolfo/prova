package page;

import org.openqa.selenium.WebDriver;

import testes.DSL;


/**
 * @author dpandolfo
 * Classe responsável pelo padrão Page Objects, criei apenas uma Page para aplicar no Desafio.
 *
 */
public class Page {
	
	private DSL dsl;
	
	public Page(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	public void setCombo(String version) {
		dsl.selectComboById("switch-version-select", version);
	}
	
	public void addCustomer() {
		dsl.clickElementByClassName("el-plus");
	}
	
	public void setCustomerName(String name) {
		dsl.writeFieldById("field-customerName", name);
	}
	
	public void setContactLastName(String lastName) {
		dsl.writeFieldById("field-contactLastName", lastName);
	}
	
	public void setContactFirstName(String contactFirsName) {
		dsl.writeFieldById("field-contactFirstName", contactFirsName);
	}
	
	public void setPhone(String Phone) {
		dsl.writeFieldById("field-phone", Phone);
	}
	
	public void setAddressLine1(String addressLine1) {
		dsl.writeFieldById("field-addressLine1", addressLine1);
	}
	
	public void setAddressLine2(String addressLine2) {
		dsl.writeFieldById("field-addressLine2", addressLine2);
	}
	
	public void setCity(String city) {
		dsl.writeFieldById("field-city", city);
	}
	
	public void setState(String state) {
		dsl.writeFieldById("field-state", state);
	}
	
	public void setPostalCode(String postalCode) {
		dsl.writeFieldById("field-postalCode", postalCode);
	}
	
	public void setCountry(String country) {
		dsl.writeFieldById("field-country", country);
	}
	
	public void setFromEmployeer(String fromEmployeer) {
		dsl.writeFieldById("field-country", fromEmployeer);
		dsl.clickElementById("field_salesRepEmployeeNumber_chosen");
		dsl.writeFieldByXpath("//*[@id='field_salesRepEmployeeNumber_chosen']/div/div/input", fromEmployeer);	
	}
	
	public void setCreditLimit(String creditLimit) {
		dsl.writeFieldById("field-creditLimit", creditLimit);
	}
	
	public void clickSave() {
		dsl.clickElementById("form-button-save");
	}

	public void clickReturn() {
		dsl.clickElementByLinkText("Go back to list");
	}
	
	public void clickSearch() {
		dsl.clickElementByClassName("el-search");
	}
	
	public void searchText(String text) {
		dsl.writeFieldByClassName("search-input-big", text);
	}
	
	public void clickCheckBoxActions() {
		dsl.clickElementByCss(".select-all-none");
	}
	
	public void clickDeleteAction() {
		dsl.clickElementByCss(".delete-selected-button");
	}
	
	public void sendTabKeyFromEmployeer() {
		dsl.sendTabElementByXpath("//*[@id='field_salesRepEmployeeNumber_chosen']/div/div/input");
	}
	
	public void sendTabKeySearchText() {
		dsl.sendTabElementByClassName("search-input-big");
	}
	
}
