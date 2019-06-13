package com.qa.pageobjects;

import com.qa.testbase.BrowsersEnum;
import com.qa.wait.WaitForUrlToBe;
import org.openqa.selenium.WebDriver;


public class ManagementCenterPage extends BaseAppPage {

  private static final String MANAGEMENT_CENTER_PAGE = DOMAIN + "/mancenter/dev"; 
  
  public ManagementCenterPage(WebDriver driver, BrowsersEnum browser) {
    super(driver, browser);
  }

  @Override
  protected void isLoaded() throws Error {
    new WaitForUrlToBe(driver).apply(MANAGEMENT_CENTER_PAGE);
  }


}
