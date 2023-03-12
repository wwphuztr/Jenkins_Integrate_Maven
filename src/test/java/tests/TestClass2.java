package tests;

import com.base.BaseClass;
import com.utility.Log;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass2 extends BaseClass {

    @Test
    public void wordPressTest() throws InterruptedException {
        Log.startTestCase("This is a wordPressTest case");
        Log.info("Entering admin name");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");

        Log.info("Entering password name");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("admin123654");

        Log.info("Click to enter into the system");
        driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]")).click();

        Thread.sleep(2000);
    }
}
