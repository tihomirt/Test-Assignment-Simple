package com.qa.pageobjects;

import com.qa.testbase.BrowsersEnum;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Handling all actions related to the menu on the left. 
 * @author Tihomir Turzai
 *
 */
public class MenuSection extends BasePage {

  public MenuSection(WebDriver driver, BrowsersEnum browser) {
    super(driver, browser);
  }
  
  /**
   * Clicks on an item on the menu from the left.
   * @param menuItem - 
   * @return
   */
  public BasePage click(MenuItem menuItem) {
    driver.findElement(By.cssSelector("[data-test='" + menuItem.getLocator() + "']")).click();
    switch (menuItem) {
      case Maps:
        return new MapsPage(driver, browser);
      default:
        Assert.fail("Menu item not implemented.");
    }
    return null;
  }

  public enum MenuItem {
    Maps("menu-maps");

    private String locator;

    MenuItem(String locator) {
      this.locator = locator;
    }

    String getLocator() {
      return locator; 
    }
  }

}
