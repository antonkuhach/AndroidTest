package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import scenarios.AndroidSetup;

public class DragAndDropPage extends AbstractPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag me!']")
    private AndroidElement dragMeElement;

    @AndroidFindBy(id = "dropzone")
    private AndroidElement dropzone;

    public void dragAndDrop() {
        new TouchAction(AndroidSetup.getInstance().getDriver()).press(dragMeElement).waitAction().moveTo(dropzone).release().perform();
    }

    @Override
    public boolean isPageOpened() {
        return dragMeElement.isDisplayed();
    }
}
