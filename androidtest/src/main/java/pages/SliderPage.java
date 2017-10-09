package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import scenarios.AndroidSetup;

public class SliderPage extends AbstractPage {
    @AndroidFindBy(xpath = "//android.widget.SeekBar[@content-desc = 'slider']")
    private AndroidElement slider;

    public void slideToTheRight() {
        Point upperLeft = getSliderPoint();
        Dimension dimensions = slider.getSize();
        Point sliderLocation = new Point(upperLeft.getX() + dimensions.getWidth()/2,
                upperLeft.getY() + dimensions.getHeight()/2);
        new TouchAction(AndroidSetup.getInstance().getDriver()).press(sliderLocation.getX(),sliderLocation.getY())
                .moveTo(sliderLocation.getX() / 2 , sliderLocation.getY()).perform().release();
    }

    public Point getSliderPoint() {
        return slider.getLocation();
    }

    @Override
    public boolean isPageOpened() {
        return slider.isDisplayed();
    }
}
