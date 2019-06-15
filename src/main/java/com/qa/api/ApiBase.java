package com.qa.api;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import org.openqa.selenium.WebDriver;


abstract public class ApiBase {

  private static final String BASE_URI = "http://localhost";
  private static final Integer PORT = 8081;
  private static final String BASE_PATH = "/mancenter/api";
  
  private WebDriver driver; 
  
  ApiBase (WebDriver driver) {
    this.driver = driver;
    baseURI = BASE_URI;
    port = PORT;
    basePath = BASE_PATH;
  }

  public WebDriver getDriver() {
    return driver;
  }
  
}
