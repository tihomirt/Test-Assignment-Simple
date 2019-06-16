package com.qa.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;


public class ClustersDevMapApi extends ApiBase {

  public static final String CLUSTERS_DEV_MAP_API_ENDPOINT = "/clusters/dev/maps";
  
  public ClustersDevMapApi(WebDriver driver) {
    super(driver);
  }

  /**
   * Get request to collect information about maps.
   * Endpoint: /clusters/dev/maps
   * @return
   */
  public Response getMapInformation() {
    Map<String, String> map = Collections.unmodifiableMap(getDriver().manage().getCookies().stream()
        .collect(Collectors.toMap(Cookie::getName, Cookie::getValue)));
    return given()
        .cookies(map)
        .when()
        .get(CLUSTERS_DEV_MAP_API_ENDPOINT)
        .thenReturn();
  }
  
}
