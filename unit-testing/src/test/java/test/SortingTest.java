package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTest extends BaseTest {

    @Test(priority = 1)
    public void selectPriceLowToHigh(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        sortingPage.clickSortDropdown();
        sortingPage.selectSortOptionByVisibleText("Price (low to high)");

        List<Double> actualPrices = sortingPage.collectPrices();
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        Assert.assertEquals(actualPrices, expectedPrices, "Prices are not sorted from low to high");
    }

    @Test(priority = 2)
    public void selectPriceHighToLow(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        sortingPage.clickSortDropdown();
        sortingPage.selectSortOptionByVisibleText("Price (high to low)");

        List<Double> actualPrices = sortingPage.collectPrices();
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices, Collections.reverseOrder());

        Assert.assertEquals(actualPrices, expectedPrices, "Prices are not sorted from high to low");
    }
}
