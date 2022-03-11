package utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;
import org.junit.jupiter.api.*;

public class Driver {

    static Browser browser;
    static Playwright playwright;
    protected BrowserContext browserContext;
    protected static Page page;
    static ConfigFileReader configFileReader = new ConfigFileReader();

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        String browserTypeAsString = configFileReader.getConfigValue("browser");
        boolean headlessMode = Boolean.parseBoolean(configFileReader.getConfigValue("headless.mode"));
        switch (browserTypeAsString) {
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode).setChannel("chrome"));
                break;
            case "msedge":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headlessMode).setChannel("msedge"));
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported for " + browser);
        }
    }

    @BeforeEach
    void setUp() {
        browserContext = browser.newContext(new Browser.NewContextOptions().setColorScheme(ColorScheme.DARK));
        page = browserContext.newPage();
        page.navigate(configFileReader.getConfigValue("homepage.url"));
    }

    @AfterEach
    void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browserContext != null) {
            browserContext.close();
        }
    }

    @AfterAll
    static void closeContext() {
        if (browser != null) {
            browser.close();
        }
        playwright.close();
    }
}
