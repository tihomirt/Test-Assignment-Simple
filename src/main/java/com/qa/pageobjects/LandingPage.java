package com.qa.pageobjects;

import com.qa.testbase.BrowsersEnum;
import com.qa.wait.WaitForElementToAppear;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

  private static final String LANDING_PAGE = DOMAIN + "/mancenter"; 

  private static final String LANDING_USERNAME = "testerX";
  private static final String LANDING_PASSWORD = "Q1w2e3r4_";

  @FindBy(name = "username")
  private WebElement username;

  @FindBy(name = "password")
  private WebElement password;

  @FindBy(css = "button.btn")
  private WebElement searchField;

  public LandingPage(WebDriver driver, BrowsersEnum browser) {
    super(driver, browser);
  }
  
  @Override
  protected void isLoaded() throws Error {
    driver.get(LANDING_PAGE);
    
    new WaitForElementToAppear(driver).apply(username);
    new WaitForElementToAppear(driver).apply(password);
    new WaitForElementToAppear(driver).apply(searchField);
  }

  /**
   * Successful login with the given username and password.
   * @param name - username
   * @param pass - password
   * @return management center page
   */
  private ManagementCenterPage successfulLogin(String name, String pass) {
    username.sendKeys(name);
    password.sendKeys(pass);
    searchField.click();

    return new ManagementCenterPage(driver, browser);
  }
  
  public ManagementCenterPage defaultLogin() {
    return successfulLogin(LANDING_USERNAME, LANDING_PASSWORD);
  }
  
}
