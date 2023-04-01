package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

    WebDriver _driver;

    @BeforeClass
    public void setup() {
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        Path webSite = Paths.get("Test Automation Task//Test Automation Task//Application//EHS.html");
        _driver.get(webSite.toUri().toString());
    }

    @AfterClass
    public void teardown() {
        _driver.quit();
    }

    public WebDriver getDriver() {
        return this._driver;
    }
}