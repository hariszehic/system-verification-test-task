package webTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BasePage;

import java.util.List;

public class EhsItemsPage extends BasePage {

    public EhsItemsPage(WebDriver driver) {
        super(driver);
    }

    By listAllItemsButton = By.id("ListAllItemsButton");
    By itemName = By.id("NameField");
    By itemMaterial = By.id("MaterialField");
    By itemManufacturer = By.id("ManufacturerField");
    By itemPrice = By.id("RetailPriceField");
    By itemId = By.id("ProductId");
    By itemIdField = By.id("ProductIdField");
    By findButton = By.id("FindItemButton");
    By itemsListHeader = By.xpath("//th[contains(text(),'EHS - All Items')]");
    By ehsItems = By.xpath("//tbody/tr");
    String itemInListButton = "OpenItem%sButton";

    public void clickListAllItemsButton() {
        clickElement(listAllItemsButton);
    }

    public Boolean isItemsListHeaderDisplayed() {
        return isElementDisplayed(itemsListHeader);
    }

    public Integer getItemListSize() {
        List<WebElement> elements = getElements(ehsItems);
        return elements.size() - 1;
    }

    public void openItemInList(String itemInList) {
        clickElement(By.id(itemInListButton.replace("%s", itemInList)));
    }

    public String getItemName() {
        return getElementValue(itemName);
    }

    public String getItemMaterial() {
        return getElementValue(itemMaterial);
    }

    public String getItemManufacturer() {
        return getElementValue(itemManufacturer);
    }

    public String getItemPrice() {
        return getElementValue(itemPrice);
    }

    public String getItemId() {
        return getElementText(itemId);
    }

    public void searchForItem(String itemId) {
        fillTextField(itemIdField, itemId);
        clickElement(findButton);
    }
}
