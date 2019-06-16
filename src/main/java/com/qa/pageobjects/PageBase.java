package com.qa.pageobjects;

import com.qa.testbase.BrowsersEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract base class for holding common elements.
 *
 */
abstract class PageBase extends LoadableComponent<PageBase> {

  protected static final Logger logger = LoggerFactory.getLogger(PageBase.class);
  protected static final String DOMAIN = "http://localhost:8081";
  
  protected WebDriver driver;
  protected BrowsersEnum browser;

  public PageBase(final WebDriver driver, BrowsersEnum browser) {
    this.driver = driver;
    this.browser = browser;

    logger.info("Currently on page: " + this.getClass().getSimpleName());

    PageFactory.initElements(driver, this);
    //trigger the load() -> isLoaded() -> load() process
    this.get();
  }

  @Override
  protected void load() {

  }

  @Override
  protected void isLoaded() throws Error {

  }
  
}