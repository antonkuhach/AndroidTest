package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends AbstractPage {
    @AndroidFindBy(className = "android.widget.Button")
    private AndroidElement loginButton;

    public SamplesListPage clickLogin() {
        loginButton.click();
        return new SamplesListPage();
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
