
         package runner;
    
        import org.junit.AfterClass;
        import org.junit.runner.RunWith;
        
        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;
        import pages.BasePage;
       
        @RunWith(Cucumber.class)
        @CucumberOptions(

            plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter." , "json:target/cucumber-reports.json"},
            feature = "src/test/resources/feature",
            glue = "steps",
            tags = "@Amazon"
        )
                
        public class runner{
        @AfterClass 
        public static void cleanDriver(){
            BasePage.closeBrowser();
            }
        
        }
        
        
         

