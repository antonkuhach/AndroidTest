package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import scenarios.AndroidSetup;

public class DoubleTapPage extends AbstractPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Double Tap Demo']")
    private AndroidElement doubleTapHeader;

    @AndroidFindBy(id = "doubleTapMe")
    private AndroidElement doubleTapButton;

    public void performDoubleTap() {
        new TouchAction(AndroidSetup.getInstance().getDriver()).press(doubleTapButton).release()
                .press(doubleTapButton).release().perform();
    }

    @Override
    public boolean isPageOpened() {
        return doubleTapHeader.isDisplayed();
    }
}
