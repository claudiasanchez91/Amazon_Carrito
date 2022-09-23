package steps;
import org.openqa.selenium.OutputType;
import org.apenqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import pages.driver;

public class Hooks extends BasePage{

    public Hooks() {
        super(driver);
    }
   
  @After 
  public void tearDown(Scenario Scenario){
      if(scenario.isFailed()){
      scenario.write("Scenario fallando, referirse a la imagen adjunta.");
       final byte[] screenshot =((TakesScreenshot)driver)
                    .getScreenhotAs(OutputType.BYTES);
          scenario.enbed(screenshot,"image/png");
      }
  }


    

