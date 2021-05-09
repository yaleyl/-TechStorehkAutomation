/*
 * 
 * @author Emine Balpetek
 */


package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.techstorehk.steps"},
        plugin = {"pretty", "html:target/reporthtml/HtmlReports.html", "json:target/mycucumber.json"}, strict = true,
        tags = "@Regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
