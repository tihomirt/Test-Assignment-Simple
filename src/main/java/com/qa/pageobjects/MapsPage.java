package com.qa.pageobjects;

import com.qa.testbase.BrowsersEnum;
import com.qa.wait.WaitForUrlToBe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MapsPage extends AppPageBase {

  private static final String MAPS_PAGE = DOMAIN + "/mancenter/dev/maps"; 

  public MapsPage(WebDriver driver, BrowsersEnum browser) {
    super(driver, browser);
  }

  @Override
  protected void isLoaded() throws Error {
    new WaitForUrlToBe(driver).accept(MAPS_PAGE);
  }

  /**
   * Return the contents of the second column from the line 
   * which contains the map named default.
   * @return
   */
  public Integer getNumOfEntriesForMapWithName(String mapName) {
    return Integer.parseInt(driver.findElements(
        By.xpath("//a[@data-test-attribute='" + mapName + "']/../../div"))
        .get(1)
        .getText());
  }
}
