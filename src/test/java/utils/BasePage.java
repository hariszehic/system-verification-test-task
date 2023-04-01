package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(10));
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void clickElement(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void fillTextField(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public boolean isElementDisplayed(By elementBy) {
        return driver.findElement(elementBy).isDisplayed();
    }

    public List<WebElement> getElements(By elementBy) {
        return driver.findElements(elementBy);
    }

    public String getElementText(By elementBy) {
        return driver.findElement(elementBy).getText();
    }

    public String getElementValue(By elementBy) {
        return driver.findElement(elementBy).getAttribute("value");
    }
}
