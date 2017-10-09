package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VerticalSwipingPage extends AbstractPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vertical swiping']")
    private AndroidElement verticalSwipingPageHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=' Karma']")
    private AndroidElement karma;

    public boolean isBottomDisplayed() {
        return karma.isDisplayed();
    }

    @Override
    public boolean isPageOpened() {
        return verticalSwipingPageHeader.isDisplayed();
    }
}
