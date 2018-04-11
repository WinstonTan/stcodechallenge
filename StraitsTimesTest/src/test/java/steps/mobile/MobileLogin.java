package steps.mobile;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;

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
        WebDriverWait wait = new WebDriverWait(base.androidDriver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ImageButton']")));
    }

    @And("^I tap on drawer button to open drawer$")
    public void iTapOnDrawerButtonToOpenDrawer() throws Throwable {
        base.androidDriver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
    }

    @Then("^I tap on 'LOGIN' button$")
    public void iTapOnLOGINButton() throws Throwable {
        base.androidDriver.findElement(By.id("tv_login")).click();
    }

    @When("^Login screen loaded$")
    public void loginScreenLoaded() throws Throwable {
        base.androidDriver.findElementById("tv_login_label");
    }

    @Then("^I entered ([^\"]*) and ([^\"]*)$")
    public void iEnteredLoginIdAndPassword(String loginId, String password) throws Throwable {
        base.androidDriver.findElementById("et_ldap_login_username").sendKeys(loginId);
        base.androidDriver.findElementById("et_ldap_login_password").sendKeys(password);
    }

    @And("^I tap on 'Continue' button$")
    public void iTapOnContinueButton() throws Throwable {
        base.androidDriver.findElementById("btn_ldap_login_continue").click();
    }

    @When("^I tap on drawer button$")
    public void iTapOnDrawerButton() throws Throwable {
        base.androidDriver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
    }

    @Then("^I should see my ([^\"]*) and 'LOGOUT' button$")
    public void iShouldSeeMyLoginIdAndLogoutButton(String loginId) throws Throwable {
        String loginText = base.androidDriver.findElementById("tv_login_name").getText();
        Assert.assertEquals(loginText.equals("Logged in as " + loginId), true);
        base.androidDriver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
    }

    @And("^I tap on 'ST NOW' Tab$")
    public void iTapOnSTNOWTab() throws Throwable {
        base.androidDriver.findElementById("tv_tab_title").click();
    }

    @And("^I scroll all the way down to the bottom$")
    public void iScrollAllTheWayDownToTheBottom() throws Throwable {
        AndroidElement list = (AndroidElement) base.androidDriver.findElement(By.id("webViewLiveContent"));
        MobileElement loadMoreBtn = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\"LOAD MORE\"));"));
    }

    @Then("^I should see the 'LOAD MORE' button$")
    public void iShouldSeeTheLOADMOREButton() throws Throwable {
        base.androidDriver.findElement(By.xpath("//*[text()='LOAD MORE']"));
    }
}
