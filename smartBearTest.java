import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class smartBearTest {

    WebDriver driver;
    String webSiteURL = "https://smartbear.com/";
    String webDriverPath = "C:\\Sergey\\Java\\Tools\\FirefoxDriver\\geckodriver.exe";

//    -- VARIABLES --

    int prodPlanAndTrackLinksQty = 4;
    int prodDesignAndBuildLinksQty = 5;
    int prodTestAndValidateLinksQty = 5;
    int prodLoadAndMonitorLinksQty = 3;
    int solutionLinksQty = 14;
    int integrationLinksQty = 4;
    int supportLinksQty = 15;
    int educationLinksQty = 4;
    String centralText = "SmartBear Named a Leader in the 2018 Gartner Magic Quadrant for Software Test Automation*";

//    ---------------

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.gecko.driver", webDriverPath);
        driver = new FirefoxDriver();
        driver.get(webSiteURL);
    }

    @Test()
    public void websiteUrlTest() {
        Assert.assertEquals(webSiteURL, driver.getCurrentUrl());
        System.out.println(webSiteURL + " loaded successfully");
    }

    @Test(priority = 2)
    public void centralTextTest() {
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.display-1")).getText(), centralText);
        System.out.println("Central text is present");
    }


    @Test(priority = 1)
    public void linksTest() throws InterruptedException {

//        Products - Plan and Track
        driver.findElement(By.cssSelector("li.nav-item:nth-child(1)")).click();
        WebElement planDriver = driver.findElement(By.cssSelector("div.col-lg-3:nth-child(1)"));
        List<WebElement> linksProducts = planDriver.findElements(By.className("item-name"));

        Assert.assertEquals(prodPlanAndTrackLinksQty, linksProducts.size());
        System.out.println("Plan & Track has " + linksProducts.size() + " links :");

        for (WebElement s : linksProducts) {
            System.out.println(s.getText());
            Thread.sleep(500);
        }
        System.out.println();

//        Products - Design and Build
        WebElement designDriver = driver.findElement(By.cssSelector("div.col-lg-3:nth-child(2)"));
        List<WebElement> linksDesignBuild = designDriver.findElements(By.className("item-name"));

        Assert.assertEquals(prodDesignAndBuildLinksQty, linksDesignBuild.size());
        System.out.println("Design & Build has " + linksDesignBuild.size() + " links:");

        for (WebElement s : linksDesignBuild) {
            System.out.println(s.getText());
        }
        System.out.println();

//        Product - Test and Validate
        WebElement testDriver = driver.findElement(By.cssSelector("div.col-lg-3:nth-child(3)"));
        List<WebElement> linksTest = testDriver.findElements(By.className("item-name"));

        Assert.assertEquals(prodTestAndValidateLinksQty, linksTest.size());
        System.out.println("Test & Validate has " + linksTest.size() + " links:");

        for (WebElement s : linksTest) {
            System.out.println(s.getText());
        }
        System.out.println();

//        Product - Load and Monitor
        WebElement loadDriver = driver.findElement(By.cssSelector("div.col-lg-3:nth-child(4)"));
        List<WebElement> linksLoad = loadDriver.findElements(By.className("item-name"));

        Assert.assertEquals(prodLoadAndMonitorLinksQty, linksLoad.size());
        System.out.println("Load & Monitor has " + linksLoad.size() + " links:");

        for (WebElement s : linksLoad) {
            System.out.println(s.getText());
        }
        System.out.println();

//        Solutions - solution
        driver.findElement(By.cssSelector("li.nav-item:nth-child(2)")).click();
        List<WebElement> solInt = driver.findElements(By.cssSelector(".col-12.col-lg-6.prod-col"));

        WebElement solution = solInt.get(0);
        List<WebElement> linksSolution = solution.findElements(By.className("item-name"));
        Assert.assertEquals(solutionLinksQty, linksSolution.size());
        System.out.println("Solution has " + linksSolution.size() + " links");
        System.out.println();

//      Solutions - integration
        WebElement integration = solInt.get(1);
        List<WebElement> linksIntegration = integration.findElements(By.className("item-name"));
        Assert.assertEquals(integrationLinksQty, linksIntegration.size());
        System.out.println("Integration has " + linksIntegration.size() + " links");
        System.out.println();

//         Resources - Support
        driver.findElement(By.cssSelector("li.nav-item:nth-child(3)")).click();
        WebElement support = solInt.get(2);
        List<WebElement> linksSupport = support.findElements(By.className("item-name"));

        Assert.assertEquals(supportLinksQty, linksSupport.size());
        System.out.println("Support has " + linksSupport.size() + " links");
        System.out.println();

//        Resources - Education
        WebElement education = solInt.get(3);
        List<WebElement> linksEducation = education.findElements(By.className("item-name"));

        Assert.assertEquals(educationLinksQty, linksEducation.size());
        System.out.println("Education has " + linksEducation.size() + " links");
        System.out.println();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }


}