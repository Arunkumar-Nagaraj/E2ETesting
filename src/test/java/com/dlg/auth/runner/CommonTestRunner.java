package com.dlg.auth.runner;

import com.dlg.auth.ConstantVariables.Constant;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        glue = {Constant.glue, ""},
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json", "junit:target/cucumber-reports/CucumberTestReport.xml",
                "pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        features = {Constant.featurefiles},
        tags = {Constant.guiTags}
)
public class CommonTestRunner extends AbstractTestNGCucumberParallelTests {

    private static long duration;

    @BeforeClass
    public static void before() {
        duration = System.currentTimeMillis();
        System.out.println("Thread Id  | Scenario Num       | Step Count");
    }

    @AfterClass
    public static void after() {
        duration = System.currentTimeMillis() - duration;
        System.out.println("DURATION - " + duration);
    }
}
