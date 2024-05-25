package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath ="//*[contains(text(),'Products')]")
    WebElement prodcutText;

    public String getProductText(){
        return prodcutText.getText();
    }


}
