package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import scenarios.AndroidSetup;

public class LongPressPage extends AbstractPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Long Press Demo']")
    private AndroidElement longPressHeader;

    @AndroidFindBy(id = "longpress")
    private AndroidElement longPressButton;

    public void performLongPress() {
        new TouchAction(AndroidSetup.getInstance().getDriver()).longPress(longPressButton).perform();
    }

    @Override
    public boolean isPageOpened() {
        return longPressHeader.isDisplayed();
    }
}
