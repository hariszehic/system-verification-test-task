package webTests.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseTest;
import webTests.pages.EhsItemsPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EhsItemSearchTest extends BaseTest {

    WebDriver webDriver;
    EhsItemsPage ehsItemsPage;
    List<String> itemIds = new ArrayList<>();

    @BeforeClass
    void driverSetup() {
        webDriver = getDriver();
        ehsItemsPage = new EhsItemsPage(webDriver);
    }

    @Test
    void verificationOfItemList() {
        ehsItemsPage.clickListAllItemsButton();
        assertTrue(ehsItemsPage.isItemsListHeaderDisplayed());
        assertEquals(ehsItemsPage.getItemListSize(), 9);
    }

    @Test(priority = 1)
    void verificationOfSpecificItems() {
        ehsItemsPage.openItemInList("1");
        itemIds.add(verifySpecificItem("EHS Item 1", "Bronze", "Boston Item LLC", "$53.50"));
        webDriver.navigate().back();
        ehsItemsPage.openItemInList("2");
        itemIds.add(verifySpecificItem("EHS Item 2", "Bronze", "Boston Item LLC", "$37.10"));
        webDriver.navigate().back();
        ehsItemsPage.openItemInList("3");
        itemIds.add(verifySpecificItem("EHS Item 3", "Zinc", "Boston Item LLC", "$93.00"));
        webDriver.navigate().back();
        ehsItemsPage.openItemInList("4");
        itemIds.add(verifySpecificItem("EHS Item 4", "Plywood", "Boston Item LLC", "$22.00"));
        webDriver.navigate().back();
        ehsItemsPage.openItemInList("5");
        itemIds.add(verifySpecificItem("EHS Item 5", "Air", "New York Item LLC", "$1.95"));
        webDriver.navigate().back();
        ehsItemsPage.openItemInList("6");
        itemIds.add(verifySpecificItem("EHS Item 6", "Copper", "New York Item LLC", "$5.00"));
        webDriver.navigate().back();
        ehsItemsPage.openItemInList("7");
        itemIds.add(verifySpecificItem("EHS Item 7", "Uranium", "New York Item LLC", "$32.00"));
        webDriver.navigate().back();
        ehsItemsPage.openItemInList("8");
        itemIds.add(verifySpecificItem("EHS Item 8", "Gold", "New York Item LLC", "$142.00"));
        webDriver.navigate().back();
        ehsItemsPage.openItemInList("9");
        itemIds.add(verifySpecificItem("EHS Item 9", "Plastic", "Svedala Prylfabrik AB", "$3.50"));
        webDriver.navigate().back();
        webDriver.navigate().back();
    }

    @Test(priority = 2)
    void verificationOfSearchItemsMethod() {
        ehsItemsPage.searchForItem(itemIds.get(0));
        verifySpecificItem("EHS Item 1", "Bronze", "Boston Item LLC", "$53.50");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem(itemIds.get(1));
        verifySpecificItem("EHS Item 2", "Bronze", "Boston Item LLC", "$37.10");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem(itemIds.get(2));
        verifySpecificItem("EHS Item 3", "Zinc", "Boston Item LLC", "$93.00");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem(itemIds.get(3));
        verifySpecificItem("EHS Item 4", "Plywood", "Boston Item LLC", "$22.00");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem(itemIds.get(4));
        verifySpecificItem("EHS Item 5", "Air", "New York Item LLC", "$1.95");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem(itemIds.get(5));
        verifySpecificItem("EHS Item 6", "Copper", "New York Item LLC", "$5.00");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem(itemIds.get(6));
        verifySpecificItem("EHS Item 7", "Uranium", "New York Item LLC", "$32.00");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem(itemIds.get(7));
        verifySpecificItem("EHS Item 8", "Gold", "New York Item LLC", "$142.00");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem(itemIds.get(8));
        verifySpecificItem("EHS Item 9", "Plastic", "Svedala Prylfabrik AB", "$3.50");
        webDriver.navigate().back();
        ehsItemsPage.searchForItem("1111");
        assertEquals(ehsItemsPage.getItemId(), "Not Found!");

    }

    String verifySpecificItem(
            String itemName,
            String itemMaterial,
            String itemManufacturer,
            String itemPrice
    ) {
        assertEquals(ehsItemsPage.getItemName(), itemName);
        assertEquals(ehsItemsPage.getItemMaterial(), itemMaterial);
        assertEquals(ehsItemsPage.getItemManufacturer(), itemManufacturer);
        assertEquals(ehsItemsPage.getItemPrice(), itemPrice);
        return ehsItemsPage.getItemId();
    }
}
