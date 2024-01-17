package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass<Scenario> {
	public WebDriver driver;
	public FileUtility fileutils=new FileUtility();
	public Webdriverutility webdriverutils= new Webdriverutility();

	@BeforeMethod
	public void setUp() throws IOException {
		
		String browser= fileutils.readDataFromProprtyFile("browsername");
		if (browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(fileutils.readDataFromProprtyFile("url"));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
            captureScreenshot(result.getName());
		}
		driver.manage().window().minimize();
		driver.quit();
	}

	private void captureScreenshot(String testName) {
        // Capture screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination folder for storing screenshots
        String destinationFolder = "screenshots/";
        createDirectoryIfNotExists(destinationFolder);

        // Build the path for the screenshot file
        String screenshotPath = destinationFolder + testName + "_failure.png";

        // Copy the screenshot to the destination path
        try {
            Files.copy(screenshot.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot captured and saved at: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createDirectoryIfNotExists(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + directoryPath);
            } else {
                System.err.println("Failed to create directory: " + directoryPath);
            }
        }
    }

}
