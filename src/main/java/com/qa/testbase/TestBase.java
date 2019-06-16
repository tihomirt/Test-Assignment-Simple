package com.qa.testbase;

import com.qa.testbase.driverfactory.DriverFactory;
import com.qa.testbase.extensions.CloseDriverExtension;
import com.qa.testbase.extensions.LogExtension;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


@ExtendWith(LogExtension.class)
@ExtendWith(CloseDriverExtension.class)
@RunWith(JUnitPlatform.class)
public class TestBase {

  public static final int IMPLICIT_WAIT_TIME  = 10;
  protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);

  private static BrowsersEnum browser;
  protected WebDriver driver;

  //load the config parameters in static block
  static {
    MDC.put("methodName", "TestBase-static");

    browser = getBrowserTypeProperty(System.getProperty("browser"));
    logger.info("Browser set to: " + browser);

    MDC.remove("methodName");
  }
  
  /**
   * Driver creation.
   */
  public TestBase() {
    this.driver = DriverFactory.createDriver(browser);
    driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
  }

  public WebDriver getDriver() {
    return driver;
  }
  
  public BrowsersEnum getBrowser() {
    return browser;
  }  

  private static BrowsersEnum getBrowserTypeProperty(String browserProperty)
      throws IllegalArgumentException {
    if (browserProperty == null || browserProperty.isEmpty()) {
      logger.info("Browser was null. Setting chrome as browser.");
      return BrowsersEnum.CHROME;
    }

    BrowsersEnum browser = BrowsersEnum.valueOf(browserProperty.toUpperCase());
    logger.info("Browser identified: {},", browser);
    return browser;
  }

}
