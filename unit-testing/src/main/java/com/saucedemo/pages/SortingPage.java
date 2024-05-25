package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingPage extends BasePage{

    public SortingPage(WebDriver driver){
        super(driver);
    }
    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;

    @FindBy(xpath = "//*[contains(text(),'$.')]")
    List<WebElement> priceElements;


    public void clickSortDropdown(){
        sortDropdown.click();
    }

    public void selectSortOptionByVisibleText(String visibleText){
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(visibleText);
    }

    public List<Double> collectPrices(){
        ArrayList<Double> prices = new ArrayList<>();
        for(WebElement element : priceElements){
            String priceText = element.getText().replaceAll("\\D", ""); // Remove non-numeric characters
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        return prices;
    }
}
