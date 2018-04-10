package steps.mobile;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MobileLogin extends base.BaseUtil {

    private base.BaseUtil base;

    public MobileLogin(base.BaseUtil base)
    {
        this.base = base;
    }

    @Given("^ST app is launched$")
    public void webBrowserIsLaunched() throws Throwable {
        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(base.androidDriver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.buuuk.st:id/btn_tnc_ok")));
        //System.out.print("This is the size : " + base.androidDriver.findElements(By.id("com.buuuk.st:id/btn_tnc_ok")).size());
        base.androidDriver.findElement(By.id("com.buuuk.st:id/btn_tnc_ok"));
        base.androidDriver.findElement(By.id("com.buuuk.st:id/btn_tnc_ok")).click();
    }

    @And("^Straits Times app homepage is loaded$")
    public void straitsTimesAppHomepageIsLoaded() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
