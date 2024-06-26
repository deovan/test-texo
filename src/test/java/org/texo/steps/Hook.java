package org.texo.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class Hook {
    public static WebDriver driver;
    public static RequestSpecification request;
    public static Response lastResponse;
    public static Scenario scenario;

    @Before("@web")
    public void beforeScenario(Scenario scenario) {
        Hook.scenario = scenario;
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After("@web")
    public void afterScenario() {
        if (driver != null) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
            driver.quit();
        }
    }

    @Before("@api")
    public void beforeScenarioApi(Scenario scenario) {
        Hook.scenario = scenario;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType(ContentType.JSON);
        builder.log(LogDetail.ALL);
        builder.setBaseUri("https://jsonplaceholder.typicode.com");
        request = given().spec(builder.build());
    }

    @After("@api")
    public void afterScenarioApi() {

    }

}
