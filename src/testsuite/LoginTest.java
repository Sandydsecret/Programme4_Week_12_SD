package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

    // 3.1.1 Enter “standard_user” usernamese
       sendTextToElement((By.id("user-name")),"standard_user");
    // 3.1.2 Enter “secret_sauce” password
       sendTextToElement((By.id("password")),"secret_sauce");
    // 3.1.3 Click on ‘LOGIN’ button
       clickOnElement(By.id("login-button"));
    // 3.1.4 Verify the text “PRODUCTS”
       String expectedText="Products";
       String actualText=getTextFromElement(By.className("title"));
       Assert.assertEquals("PRODUCTS not displayed",expectedText,actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
    //  3.2.1 Enter “standard_user” username
        sendTextToElement((By.id("user-name")),"standard_user");
    //  3.2.2 Enter “secret_sauce” password
        sendTextToElement((By.id("password")),"secret_sauce");
    //  3.2.3 Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
    //  3.3.4 Verify that six products are displayed on page
        int expectedNumberOfProducts=6;
        List<WebElement> productList=findElementsFromWebPage(By.xpath("//img[starts-with(@class,'inventory_item_img')]"));
        int actualNumberOfProducts=productList.size();
        Assert.assertEquals("Number of Products are not same",expectedNumberOfProducts,actualNumberOfProducts);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
