package com.qa.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForUrlToBe {

  private static final int BASIC_WAIT_TIME_IN_SECONDS = 12;
  private WebDriver driver;

  public WaitForUrlToBe(WebDriver driver) {
    this.driver = driver;
  }

  public void apply(String url) {
    WebDriverWait wait = new WebDriverWait(driver, BASIC_WAIT_TIME_IN_SECONDS);
    wait.until(ExpectedConditions.urlToBe(url));
  }  
  
}