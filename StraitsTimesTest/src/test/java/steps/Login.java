package test.java.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login extends base.BaseUtil {

    private base.BaseUtil base;

    public Login(base.BaseUtil base)
    {
        this.base = base;
    }

    @Given("^Web browser is launched$")
    public void webBrowserIsLaunched() throws Throwable {
        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        Thread.sleep(4000);
        base.driver.navigate().refresh();//trying to get rid of advertisement
    }

    @And("^Straits Times website homepage is loaded$")
    public void straitsTimesWebsiteHomepageIsLoaded() throws Throwable {
        base.driver.findElement(By.xpath("//a[text()='Login']"));
    }

    @When("^I click on top-right section Login hyperlink$")
    public void iClickOnTopRightSectionLoginHyperlink() throws Throwable {
        base.driver.findElement(By.xpath("//a[text()='Login']")).click();
    }


    @And("^I attempt to login valid ([^\"]*) and ([^\"]*)$")
    public void iEnteredValidLoginIdAndPassword(String loginId, String password) throws Throwable {
        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='j_username']")));
        base.driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys(loginId);
        base.driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys(password);
        base.driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Note: The given login credentials hits "User Name and Password are already in use" error, I have closed browsers and restarted PC. Issue still occurs. Suspecting a bug in session validation in backend in different web browsers.
        //      However issue not reproducible in android mobile app.
    }

    @Then("^I should see my ([^\"]*) and logout hyperlink on top-right$")
    public void iShouldSeeMyLoginIdAndLogoutHyperlinkOnTopRight(String loginId) throws Throwable {
        WebDriverWait wait = new WebDriverWait(base.driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//a[@name='login-user-name']")), loginId));
        base.driver.findElement(By.xpath("//a[text()='Logout']"));
    }

    @And("^I should see either image or video  present in main article$")
    public void iShouldSeeEitherImageOrVideoPresentInMainArticle() throws Throwable {
        boolean isMediaElementFound = false;

        try
        {
            base.driver.findElement(By.xpath("//div[@class='pane-content']//img"));
            isMediaElementFound = true;
        }catch (NoSuchElementException e){}

        if(!isMediaElementFound)
        {
            //I don't see video in main article, I assume the video element would be within the same div class='pane-content' for main article in homepage.
            base.driver.findElement(By.xpath("//div[@class='pane-content']//video"));
        }
    }

    @When("^I click on the main article$")
    public void iClickOnTheMainArticle() throws Throwable {
        base.driver.findElement(By.xpath("//a[@class='block-link']")).click();
    }

    @Then("^the main article page will be loaded$")
    public void theMainArticlePageWillBeLoaded() throws Throwable {

        base.driver.findElement(By.xpath("//h1[@class='headline node-title']")).click();
    }

    @And("^picture or video is present in the article$")
    public void pictureOrVideoIsPresentInTheArticle() throws Throwable {

        boolean isMediaElementFound = false;

        try
        {
            base.driver.findElement(By.xpath("//div[@class='media-group fadecount0'] //img[@class='img-responsive']"));
            isMediaElementFound = true;
        }catch (NoSuchElementException e){}

        if(!isMediaElementFound)
        {
            base.driver.findElement(By.xpath("//body[@class='-display']//video[@class='vjs-tech']"));
        }
    }



}
