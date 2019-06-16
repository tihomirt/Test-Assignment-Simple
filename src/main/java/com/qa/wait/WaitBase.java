package com.qa.wait;

import org.openqa.selenium.WebDriver;

public abstract class WaitBase {

  protected static final int BASIC_WAIT_TIME_IN_SECONDS = 12;
  private WebDriver driver;

  public WaitBase(WebDriver driver) {
    this.driver = driver;
  }

  public WebDriver getDriver() {
    return driver;
  }
  
}
