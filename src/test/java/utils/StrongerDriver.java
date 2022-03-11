package utils;

import com.microsoft.playwright.Page;

public class StrongerDriver extends Driver {

    public Page getPage() {
        return page;
    }

    protected void clickElement(String css) {
        page.hover(css);
        page.click(css);
        page.waitForLoadState();
    }

    protected void typeElement(String css, String text) {
        page.hover(css);
        page.type(css, text);
    }

    protected void navigateUrl(String url) {
        page.navigate(url);
    }
}
