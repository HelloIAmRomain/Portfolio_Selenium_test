package com.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.time.Duration;



public class PortfolioSeleniumTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable (replace with your path)
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize a WebDriver instance (in this case, Chrome)
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://www.romain-dodet.com");

        // Full screen
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Theme button
        WebElement themeButton = wait.until(ExpectedConditions.elementToBeClickable(By.tagName("input")));
        captureElementScreenshot(driver, themeButton, "theme_button.png");
        themeButton.click();

        // About link
        WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("About")));
        captureElementScreenshot(driver, aboutLink, "about_link.png");
        aboutLink.click();

        // Home link
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Home")));
        captureElementScreenshot(driver, homeLink, "home_link.png");
        homeLink.click();

        // Projects link
        WebElement projectsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Projects")));
        captureElementScreenshot(driver, projectsLink, "projects_link.png");
        projectsLink.click();

        // Resume link
        WebElement resumeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Resume")));
        captureElementScreenshot(driver, resumeLink, "resume_link.png");
        resumeLink.click();

        // Close the browser
        driver.quit();
    }

    // Function to capture a screenshot of a WebElement
    public static void captureElementScreenshot(WebDriver driver, WebElement element, String fileName) {
        // Set Folder name to store screenshots
        String folderName = "Screenshots";

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Get the location of the element
            org.openqa.selenium.Point elementLocation = element.getLocation();
            int elementWidth = element.getSize().getWidth();
            int elementHeight = element.getSize().getHeight();

            // Save the full screenshot to a file
            FileUtils.copyFile(screenshotFile, new File(folderName + "/full_screenshot_" + fileName));

            // Crop the screenshot to capture only the element
            BufferedImage fullImage = ImageIO.read(screenshotFile);
            BufferedImage elementImage = fullImage.getSubimage(elementLocation.getX(), elementLocation.getY(), elementWidth, elementHeight);
            ImageIO.write(elementImage, "png", screenshotFile);

            // Save the cropped screenshot to a file
            FileUtils.copyFile(screenshotFile, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
