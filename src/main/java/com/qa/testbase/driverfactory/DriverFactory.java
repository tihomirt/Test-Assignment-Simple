package com.qa.testbase.driverfactory;

import com.qa.testbase.BrowsersEnum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

  /**
   * Creates the appropriate Webdriver.
   * @param browser - chosen browser from BrowsersEnum
   * @return
   */
  public static WebDriver createDriver(final BrowsersEnum browser) {
    switch (browser) {
      case CHROME:
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
      case EDGE:
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
      default:
        throw new UnsupportedOperationException("Browser type is not yet supported");
    }
  }
}