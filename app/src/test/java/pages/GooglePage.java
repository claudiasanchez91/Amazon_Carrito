package pages;

public class GooglePage extends BasePage {

private String searchButton ="//input[@value='Buscar con Google']";
private String searchTextField ="//input[@title='Buscar']";
private String thirdResult ="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]";
private String addToCartButton ="//input[@id='add-to-cart-button']";
private String addedMessageText ="//*[contains(text(),'agregando al carrito')]";


public GooglePage(){
super(driver);
		
}
public void navigateToGoogle(){
	navigateTo("https://www.amazon.com");
}
public void enterSearchCriteria(String criteria) {
	write(searchTextField,criteria);
}
public void clicksearch() {
	clickElement(searchButton);
}
public void goToPage2() {
	goToLinkText("2");
}
public void pick3rdItem() {
	clickElement(thirdResult);
}
public void addToCart() {
	clickElement(addToCartButton);
	
}
public String addedToCartMessage() {
	return textFromElement(addedMessageText);
}
public void clickGoogleSearch(){
clickElement(searchButton);

}
}


