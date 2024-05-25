package test;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private LoginPage loginPage;

    @Test(priority = 1)
    public  void loginWithBothValidUsernameAndPassword(){
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        String productText = homePage.getProductText();
        Assert.assertEquals(productText,"Products","Login Failed");
    }
    @Test(priority = 2)
    public void loginWithValidUsernameAndInvalidPassword(){
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("1234");
        loginPage.clickLoginButton();

        String loginFailedMessage = loginPage.getErrorMessage();
        Assert.assertEquals(loginFailedMessage,"Epic sadface: Username and password do not match any user in this service","Valid username and invalid password test case faild");
    }
    @Test(priority = 3)
    public void loginWithValidPasswordAndInvalidUsername(){
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user123");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        String loginFailedMessage = loginPage.getErrorMessage();
        Assert.assertEquals(loginFailedMessage,"Epic sadface: Username and password do not match any user in this service","Valid password and invalid username test case faild");
    }
    @Test(priority = 4)
    public void loginWithBothInvalidUsernameAndPassword(){
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user123");
        loginPage.setPassword("1234");
        loginPage.clickLoginButton();

        String loginFailedMessage = loginPage.getErrorMessage();
        Assert.assertEquals(loginFailedMessage,"Epic sadface: Username and password do not match any user in this service","Invalid username and invalid passwordtest case faild");
    }
    @Test(priority = 5)
    public void loginWithEmptyUsernameAndPassword(){
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();

        String loginFailedMessage = loginPage.getErrorMessage();
        Assert.assertEquals(loginFailedMessage,"Epic sadface: Username is required","Login with empty username and password test failed");
    }


}
