package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NativeViewPage extends AbstractPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Native View Demo']")
    private AndroidElement nativeViewPageHeader;

    @Override
    public boolean isPageOpened() {
        return nativeViewPageHeader.isDisplayed();
    }
}
