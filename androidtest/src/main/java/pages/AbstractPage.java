package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import scenarios.AndroidSetup;

import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']")
    private AndroidElement back;

    @AndroidFindBy(id = "button1")
    private AndroidElement okButton;

    public AbstractPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AndroidSetup.getInstance().getDriver(),
                5, TimeUnit.SECONDS), this);
    }

    public void clickBack() {
        back.click();
    }

    public MobileElement scrollTo(String text){
        return (MobileElement) AndroidSetup.getInstance().getDriver().findElement(MobileBy.
                AndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".scrollable(true)).scrollIntoView(resourceId(\"android:id/list\")).scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"))"));
    }

    public void clickOk() {
        new TouchAction(AndroidSetup.getInstance().getDriver()).tap(okButton).perform();
    }

    public abstract boolean isPageOpened();
}