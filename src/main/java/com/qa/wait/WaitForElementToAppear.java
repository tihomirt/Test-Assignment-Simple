package com.qa.wait;

import java.util.function.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementToAppear extends WaitBase implements Function<WebElement, WebElement> {

  public WaitForElementToAppear(WebDriver driver) {
    super(driver);
  }

  @Override
  public WebElement apply(WebElement element) {
    WebDriverWait wait = new WebDriverWait(getDriver(), BASIC_WAIT_TIME_IN_SECONDS);
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

}