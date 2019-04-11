import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class smartBearUpdateTest {

    WebDriver driver;
    String webSiteURL = "https://smartbear.com/";
    String webDriverPath = "C:\\Sergey\\Java\\Tools\\FirefoxDriver\\geckodriver.exe";

//    -- VARIABLES --

    int prodManageAndDesignLinksQty = 3;
    int prodCreateAndMonitorLinksQty = 5;
    int prodTestLinksQty = 6;
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
    public void linksTest(){

//        Products - Manage & Design
        driver.findElement(By.cssSelector("li.nav-item:nth-child(1)")).click();
        WebElement planDriver = driver.findElement(By.cssSelector("div.col-lg-4:nth-child(1)"));
        List<WebElement> linksManageDesign = planDriver.findElements(By.className("item-name"));

        Assert.assertEquals(prodManageAndDesignLinksQty, linksManageDesign.size());
        System.out.println("Products / Manage & Design has " + linksManageDesign.size() + " links :");

        Actions actions = new Actions(driver);

        for (WebElement s : linksManageDesign) {
            System.out.println(s.getText());
        }
        System.out.println();

//        Products - Create & Monitor
        WebElement designDriver = driver.findElement(By.cssSelector("div.col-lg-4:nth-child(2)"));
        List<WebElement> linksCreateMonitor = designDriver.findElements(By.className("item-name"));

        Assert.assertEquals(prodCreateAndMonitorLinksQty, linksCreateMonitor.size());
        System.out.println("Products / Create & Monitor has " + linksCreateMonitor.size() + " links:");

        for (WebElement s : linksCreateMonitor) {
            System.out.println(s.getText());
        }
        System.out.println();

//        Products - Test
        WebElement lastPart = driver.findElement(By.cssSelector("div.col-lg-4:nth-child(3)"));
        List<WebElement> linksProdTest = lastPart.findElements(By.xpath("/html/body/form/header/div/div/nav/ul/li[1]/div/div/div/div/div/div[3]/a"));

        Assert.assertEquals(prodTestLinksQty, linksProdTest.size());
        System.out.println("Products / Test has " + linksProdTest.size() + " links:");

        for (WebElement s : linksProdTest) {
            System.out.println(s.getText());
        }
        System.out.println();
//        ==========


//        Solutions - solution
        driver.findElement(By.cssSelector("li.nav-item:nth-child(2)")).click();
        List<WebElement> solInt = driver.findElements(By.cssSelector(".col-12.col-lg-6.prod-col"));

        WebElement solution = solInt.get(0);
        List<WebElement> linksSolution = solution.findElements(By.className("item-name"));
        Assert.assertEquals(solutionLinksQty, linksSolution.size());
        System.out.println("Solutions / Solution has " + linksSolution.size() + " links:");

        for (WebElement s : linksSolution) {
            System.out.println(s.getText());
        }

        System.out.println();

//      Solutions - integration
        WebElement integration = solInt.get(1);
        List<WebElement> linksIntegration = integration.findElements(By.className("item-name"));
        Assert.assertEquals(integrationLinksQty, linksIntegration.size());
        System.out.println("Solutions / Integration has " + linksIntegration.size() + " links:");

        for (WebElement s : linksIntegration) {
            System.out.println(s.getText());
        }

        System.out.println();

//         Resources - Support
        driver.findElement(By.cssSelector("li.nav-item:nth-child(3)")).click();
        WebElement support = solInt.get(2);
        List<WebElement> linksSupport = support.findElements(By.className("item-name"));
        Assert.assertEquals(supportLinksQty, linksSupport.size());
        System.out.println("Resources / Support has " + linksSupport.size() + " links:");

        for (WebElement s : linksSupport) {
            System.out.println(s.getText());
        }

        System.out.println();

//        Resources - Education
        WebElement education = solInt.get(3);
        List<WebElement> linksEducation = education.findElements(By.className("item-name"));
        Assert.assertEquals(educationLinksQty, linksEducation.size());
        System.out.println("Resources / Education has " + linksEducation.size() + " links:");

        for (WebElement s : linksEducation) {
            System.out.println(s.getText());
        }

        System.out.println();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }


}