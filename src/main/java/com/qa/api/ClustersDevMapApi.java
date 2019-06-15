package com.qa.api;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class ClustersDevMapApi extends ApiBase{

  public static final String CLUSTERS_DEV_MAP_API_ENDPOINT = "/clusters/dev/maps";
  
  public ClustersDevMapApi(WebDriver driver) {
    super(driver);
  }

  public Response getMapInformation() {
    Set<Cookie> cookiesSet = getDriver().manage().getCookies();

    Map<String, String> map = cookiesSet.stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getValue()));
    return given()
        .cookies(map)
        .when()
        .get(CLUSTERS_DEV_MAP_API_ENDPOINT)
        .thenReturn();
  }
  
}
