package com.qa.wait;

import java.util.function.Consumer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitForUrlToBe extends WaitBase implements Consumer<String> {

  public WaitForUrlToBe(WebDriver driver) {
    super(driver);
  }

  @Override
  public void accept(String url) {
    WebDriverWait wait = new WebDriverWait(getDriver(), BASIC_WAIT_TIME_IN_SECONDS);
    wait.until(ExpectedConditions.urlToBe(url));
  }  
  
}