package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        //username elements
        sendTextToElement(By.id("txtUsername"), "Admin");

        //password elements
        sendTextToElement(By.xpath("//input[@id='txtPassword']"), "admin12");

        //forgetpassword elements
        clickOnElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));

        //actualresult
        String actualmsg = getTextFromElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));


        //Expectedresult
        String expectedmsg = "Forgot Your Password?";

        //match actual and expected result
        Assert.assertEquals("forget password ", actualmsg, expectedmsg);
    }
}
