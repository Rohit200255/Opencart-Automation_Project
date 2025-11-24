package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

    public static WebDriver dr;   // ⭐ FIX: Driver must be static for static screenshot
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"sanitary", "regression", "master","dataDriven"})
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {

        FileReader file = new FileReader("src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        switch (br.toLowerCase()) {
            case "chrome":
                dr = new ChromeDriver();
                break;

            case "edge":
                dr = new EdgeDriver();
                break;

            default:
                System.out.println("Invalid Browser name");
                return;
        }

        dr.manage().deleteAllCookies();
        dr.manage().window().maximize();
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dr.get(p.getProperty("appURL1"));
    }

    @AfterClass(groups = {"sanitary", "regression", "master","dataDriven"})
    public void tearDown() throws InterruptedException {
        dr.quit();
    }

    public String RandomAlphabets() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String RandomNumbers() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String RandomAlphaNumeric() {
        String alpha = RandomStringUtils.randomAlphabetic(5);
        String nums = RandomStringUtils.randomNumeric(5);
        return alpha + "@" + nums;
    }

    // ⭐ PERFECT WORKING SCREENSHOT FUNCTION
    public static String captureScreen(String tname) throws IOException {

        TakesScreenshot takesScreenshot = (TakesScreenshot) dr;

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        String targetFilePath = System.getProperty("user.dir") +
                "\\screenshots\\" + tname + "_" + timestamp + ".png";

        File targetFile = new File(targetFilePath);
        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
