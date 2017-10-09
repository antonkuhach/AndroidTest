package pages;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SamplesListPage extends AbstractPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Samples List']")
    private AndroidElement samplesListHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Native View']")
    private AndroidElement nativeView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Slider']")
    private AndroidElement slider;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vertical swiping']")
    private AndroidElement verticalSwiping;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag & Drop']")
    private AndroidElement dragAndDrop;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Double Tap']")
    private AndroidElement doubleTap;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Long Press']")
    private AndroidElement longPress;

    public NativeViewPage clickNativeView() {
        nativeView.click();
        return new NativeViewPage();
    }

    public SliderPage clickSlider() {
        slider.click();
        return new SliderPage();
    }

    public VerticalSwipingPage clickVerticalSwiping() {
        verticalSwiping.click();
        return new VerticalSwipingPage();
    }

    public DragAndDropPage clickDragAndDrop() {
        dragAndDrop.click();
        return new DragAndDropPage();
    }

    public DoubleTapPage clickDoubleTap() {
        doubleTap.click();
        return new DoubleTapPage();
    }

    public LongPressPage clickLongPress() {
        longPress.click();
        return new LongPressPage();
    }

    @Override
    public boolean isPageOpened() {
        return samplesListHeader.isDisplayed();
    }
}
