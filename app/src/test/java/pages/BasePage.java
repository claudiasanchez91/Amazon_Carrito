package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{

	protected static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	
	static { // BLOQUE ESTATICO
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new ChromeDriver(chromeOptions);
		wait = new WebDriverWait(driver,10); //VA ESPERAR 10 SEGUNDOS
	}
	public BasePage(WebDriver driver) {  
		BasePage.driver = driver;
		wait = new WebDriverWait(driver,10);
	}
	//FUNCION
	public static void navigateTo(String url) {
		driver.get(url);
	}
	public void goToLinkText(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}
	public static void closeBrowser() {
		driver.quit();
	}
	//CREAR UN METODO 
	private WebElement Find(String locator) {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));	
	}
	public void clickElement(String locator) {//DADO XPATH VA Y SI LO LOCALIZA DARA CLICK
		Find(locator).click();
	}
	public void write(String locator,String texToWrite) {
		Find(locator).clear();
		Find(locator).sendKeys("textToWrite");
		
	}
	public void selectFromDropdownByValue(String locator, String valueToSelect) {
		Select dropdown = new Select (Find(locator));
		
		dropdown.selectByValue(valueToSelect);
	}
	public void selectFromDropdownByIndex(String locator, int valueToSelect) {
		Select dropdown = new Select (Find(locator));
		
		dropdown.selectByIndex(valueToSelect);
	}
	public void selectFromDropdownByText(String locator, String valueToSelect) {
		Select dropdown = new Select (Find(locator));
		
		dropdown.selectByVisibleText(valueToSelect);
     }
	//PASAR EL MOUSE POR ENCIMA 
	public void hoverOverElement(String locator) {
		action.moveToElement(Find(locator));
	}
	public void doubleClik(String locator) {
		action.doubleClick(Find(locator));
	}
	public void rightClick(String locator) {
		action.contextClick(Find(locator));
	}
	public void getScreenshot(String locator,String nameOfFile) throws IOException{
		File file =Find(locator).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File(nameOfFile+".png));"));
	}
	public void seelctFromDropdownByIndex(String locator, int valueToSelect) {
		Select dropdown = new Select(Find(locator));
		dropdown.selectByIndex(valueToSelect);
	}




