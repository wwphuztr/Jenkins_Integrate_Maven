package tests;

import com.base.BaseClass;
import com.extentManager.ExtentManager;
import com.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass1 extends BaseClass {
    @Test
    public void loginPageTest() {
        WebElement imgElement = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        Assert.assertTrue(imgElement.isDisplayed());
    }

    @Test
    public void loginTest() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "OrangeHRMhj";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testcase() {

        Assert.assertTrue(true);
        ExtentManager.test.createNode("validation1");
        Assert.assertTrue(true);
        ExtentManager.test.createNode("validation2");
        Assert.assertTrue(true);
        ExtentManager.test.createNode("validation3");
        Assert.assertTrue(true);
        ExtentManager.test.createNode("validation4");
        Assert.assertTrue(true);
        ExtentManager.test.createNode("validation5");
        Assert.assertTrue(false);
    }
}
