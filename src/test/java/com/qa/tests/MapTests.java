package com.qa.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.qa.api.ClustersDevMapApi;
import com.qa.pageobjects.LandingPage;
import com.qa.pageobjects.ManagementCenterPage;
import com.qa.pageobjects.MapsPage;
import com.qa.pageobjects.MenuSection.MenuItem;
import com.qa.testbase.TestBase;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;


public class MapTests extends TestBase {

  private static final String MAP_TO_TEST = "default";

  public MapTests() {
    super();
  }

  /**
   * Test Map entries
   * 1. Load google.com
   * 2. Login with default user
   * 3. Click on the Maps from the menu on the left
   * 4. Read the second column called Entries
   * 5. Get the api entries count from the api 
   * 6. Compare the entries from the ui and the api to check if it's correct
   */
  @Test
  public void testMapEntries() {
    LandingPage landingPage = new LandingPage(driver, getBrowser());
    ManagementCenterPage managementCenterPage = landingPage.defaultLogin();
    MapsPage mapsPage = (MapsPage) managementCenterPage.getMenuSection().click(MenuItem.Maps);

    // send the cookie along with the get request
    ClustersDevMapApi mapApi = new ClustersDevMapApi(driver);
    
    @SuppressWarnings("unchecked")
    Optional<Object> defaultMap = mapApi.getMapInformation()
        .getBody().jsonPath().getList("")
        .stream()
        .filter(x -> ((Map<String, String>) x).containsValue(MAP_TO_TEST))
        .findFirst();
    
    if (defaultMap.isPresent()) {
      assertEquals(((Map)defaultMap.get()).get("entries"),
          mapsPage.getNumOfEntriesForMapWithName(MAP_TO_TEST));
    } else {
      fail("Data from api is not available.");
    }
    
    // logout after test to be able to restart the test
    mapsPage.clickLogoutButton();
  }

}
