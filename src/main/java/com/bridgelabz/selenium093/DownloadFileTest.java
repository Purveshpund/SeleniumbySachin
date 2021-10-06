package com.bridgelabz.selenium093;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DownloadFileTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "F:\\learning\\Selenium\\drivers\\geckodriver.exe");

        FirefoxProfile profile = new FirefoxProfile();

        String key = "browser.helperApps.neverAsk.saveToDisk";

        String value = "application/zip";

        profile.setPreference(key, value);
        // 0 - save to desktop, 1 - save to download folder( default), 2 - save to any other //location
        profile.setPreference("browser.download.folderList", 1);
        //save the file to the given folder location
       // profile.setPreference("browser.download.dir", "D:\\Ajit\\Others");

        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability(FirefoxDriver.PROFILE, profile);

        WebDriver driver = new FirefoxDriver(cap);

        driver.get("http://www.seleniumhq.org/download/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'3.141.59 (November 14, 2018)')]")).click();
        Thread.sleep(3000);
    }
}
