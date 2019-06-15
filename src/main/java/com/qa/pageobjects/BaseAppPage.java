package com.qa.pageobjects;

import com.qa.testbase.BrowsersEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Container for common components after the login.
 * @author Tihomir Turzai
 *
 */
abstract class BaseAppPage extends BasePage {

  @FindBy(css = "a[data-test='logout']")
  private WebElement logoutButton;
  private MenuSection menuSection;
  
  public BaseAppPage(WebDriver driver, BrowsersEnum browser) {
    super(driver, browser);
    menuSection = new MenuSection(driver, browser);
  }

  public MenuSection getMenuSection() {
    return menuSection;
  }
  
  public void clickLogoutButton() {
    logoutButton.click();
  }
  
}
