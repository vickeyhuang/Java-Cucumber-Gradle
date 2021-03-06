package java;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
		format = {"pretty", "html:build/cucumber-html-report", "json-pretty:build/cucumber-report.json"},
		features = "classpath:feature",
		glue = {"step_Definitions"}
//		tags = {"@stag","@prod"}
)
public class RunCukesTest {

}
