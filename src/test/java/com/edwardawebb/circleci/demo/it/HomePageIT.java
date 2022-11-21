package com.edwardawebb.circleci.demo.it;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class HomePageIT extends AbstractWebIT {


    @org.junit.jupiter.api.Test
    public void testHomePageButtonsUseProperMarketingCopy() throws Exception {

        WebDriver webDriver = createWebDriver();
        webDriver.get(getBaseUrl());
        assertThat("Carousel Button 1 has incorrect text",webDriver.findElement(By.id("car-btn-1")).getText(),containsString("Start Building!"));
    }


}
