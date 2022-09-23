package steps;

public class GoogleSteps{
   

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.GooglePage;

public class GoogleSteps {
	
	GooglePage google = new GooglePage();

	@Given("^The user navigates to www.amazon.com$")
	public void navigateToGoogle() {
	google.navigateToGoogle();	

	}
	@And("^search for(.+)$")
	public void enterSearchCrieria(String criteria) {
		google.enterSearchCriteria(criteria);
		google.clickGoogleSearch();
	}
	@And("^navigates to the second page$")
	public void navigateToSecondPage() {
		google.goToPage2();
	}
	
	@And("selects the third items$")
	public void selectsThirdItem() {
		google.pick3rdItem();
	}
	

	@Then("the usert is able to add it to the carts")
	public void itemCanBeAddedToTheCart() {
	google.addToCart();
	Assert.assertEquals("Agregando al carrito", google.addedToCartMessage());
	}
	
   } 
    
}
