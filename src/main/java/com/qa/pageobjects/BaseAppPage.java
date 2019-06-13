package com.qa.pageobjects;

import com.qa.testbase.BrowsersEnum;
import org.openqa.selenium.WebDriver;

/**
 * Containe rfor common components after the login.
 * @author Tihomir Turzai
 *
 */
abstract class BaseAppPage extends BasePage {

  private MenuSection menuSection;
  
  public BaseAppPage(WebDriver driver, BrowsersEnum browser) {
    super(driver, browser);
    menuSection = new MenuSection(driver, browser);
  }

  public MenuSection getMenuSection() {
    return menuSection;
  }
  
}
