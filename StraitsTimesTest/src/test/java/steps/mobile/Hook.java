package steps.mobile;


import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() throws MalformedURLException, InterruptedException{

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/resource/appPkg/");
        File app = new File(appDir, "com.buuuk.st_308.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "OnePlus One");
        capabilities.setCapability("platformVersion", "7.1.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "com.buuuk.st");
        capabilities.setCapability("appPackage", app.getAbsolutePath());
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("appActivity", "com.sph.straitstimes.views.activities.SplashActivity");


        base.androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        base.androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed())
        {
            /*
            try {
                File scrFile = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\screenshot_" + dtf.format(LocalDateTime.now())+ ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
        }
        base.androidDriver.quit();
    }
}
