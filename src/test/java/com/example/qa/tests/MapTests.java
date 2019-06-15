package com.example.qa.tests;

import static org.junit.Assert.assertEquals;
import com.qa.api.ClustersDevMapApi;
import com.qa.pageobjects.LandingPage;
import com.qa.pageobjects.ManagementCenterPage;
import com.qa.pageobjects.MapsPage;
import com.qa.pageobjects.MenuSection.MenuItem;
import com.qa.testbase.TestBase;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Optional;


public class MapTests extends TestBase {

  public MapTests() throws Exception {
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
    LandingPage landingPage = (LandingPage) new LandingPage(driver, getBrowser());
    ManagementCenterPage managmentCenterPage = landingPage.defaultLogin();
    MapsPage mapsPage = (MapsPage) managmentCenterPage.getMenuSection().click(MenuItem.Maps);

    // send the cookie along with the get request
    ClustersDevMapApi mapApi = new ClustersDevMapApi(driver);
    
    @SuppressWarnings("unchecked")
    Optional<Object> defaultMap = mapApi.getMapInformation()
    .getBody().jsonPath().getList("")
        .stream()
        .filter(x -> ((Map<String, String>) x).containsValue("default"))
        .findFirst();
    
    if (defaultMap.isPresent())
      assertEquals(((Map)defaultMap.get()).get("entries"), mapsPage.getNumOfEntriesForDefaultMap());
    mapsPage.clickLogoutButton();

  }


}
