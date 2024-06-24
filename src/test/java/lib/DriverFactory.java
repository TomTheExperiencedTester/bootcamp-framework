package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver createDriver(Browser browser){
        return switch (browser){
            case CHROME ->
                createChromeDriver();

            case FIREFOX ->
                createFirefoxDriver();

            case EDGE ->
                createEdgeDriver();

            case SAFARI ->
                createSafariDriver();
        };
    }

    private static WebDriver createSafariDriver() {
        return new SafariDriver();
    }

    private static WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }
}
