package test.java.steps;


import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.time.LocalDateTime;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Hook extends base.BaseUtil {


    private base.BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        System.setProperty("webdriver.chrome.driver", "util/bin/chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
        base.driver.get(base.url);
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed())
        {
            try {
                File scrFile = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\screenshot_" + dtf.format(LocalDateTime.now())+ ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        base.driver.quit();
    }
}
