package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //username elements
        sendTextToElement(By.id("txtUsername"),"Admin");

        //password elements
        sendTextToElement(By.xpath("//input[@id='txtPassword']"),"admin123");

        //login elements
        clickOnElement(By.xpath("//input[@id='btnLogin']"));

        //actual elements
        String actualmsg=getTextFromElement(By.xpath("//a[@id='welcome']")).substring(0,7);

        //expected result
        String expectedmsg = "Welcome";

        //actual and expected result
        Assert.assertEquals("not able to login", actualmsg, expectedmsg);
    }

    @After
    //Here After method for close the browser
    public void teardown() {
        closebrowser();

    }
}

