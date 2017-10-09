import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import scenarios.AndroidSetup;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VodQATest {
    private AndroidDriver driver;
    private LoginPage loginPage;
    private SamplesListPage sampleListPage;
    private NativeViewPage nativeViewPage;
    private SliderPage sliderPage;
    private VerticalSwipingPage verticalSwipingPage;
    private DragAndDropPage dragAndDropPage;
    private DoubleTapPage doubleTapPage;
    private LongPressPage longPressPage;

    @BeforeClass
    public void setup() {
        driver = AndroidSetup.getInstance().getDriver();
        loginPage = new LoginPage();
    }

    @Test
    public void loginTest()
    {
        sampleListPage = loginPage.clickLogin();
        assertTrue(sampleListPage.isPageOpened());
    }

    @Test(dependsOnMethods = "loginTest")
    public void nativeViewTest() {
        nativeViewPage = sampleListPage.clickNativeView();
        assertTrue(nativeViewPage.isPageOpened());
    }

    @Test(dependsOnMethods = "nativeViewTest")
    public void sliderTest() {
        nativeViewPage.clickBack();
        sliderPage = sampleListPage.clickSlider();
        sliderPage.slideToTheRight();
        int endXPoint = sliderPage.getSliderPoint().getX();
        assertEquals(endXPoint, 175);
    }

    @Test(dependsOnMethods = "sliderTest")
    public void verticalSwipingTest() {
        sliderPage.clickBack();
        verticalSwipingPage = sampleListPage.clickVerticalSwiping();
        verticalSwipingPage.scrollTo(" Karma");
        assertTrue(verticalSwipingPage.isBottomDisplayed());
    }

    @Test(dependsOnMethods = "verticalSwipingTest")
    public void dragAndDropTest() {
        verticalSwipingPage.clickBack();
        dragAndDropPage = sampleListPage.clickDragAndDrop();
        dragAndDropPage.dragAndDrop();
        String actual = driver.findElementByAccessibilityId("success").getText();
        assertEquals(actual,"Circle dropped");
    }

    @Test(dependsOnMethods = "dragAndDropTest")
    public void doubleTapTest() {
        dragAndDropPage.clickBack();
        doubleTapPage = sampleListPage.clickDoubleTap();
        doubleTapPage.performDoubleTap();
        String actual = driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'message')]").getText();
        doubleTapPage.clickOk();
        assertEquals(actual,"Double tap successful!");
    }

    @Test(dependsOnMethods = "doubleTapTest")
    public void longPressTest() {
        doubleTapPage.clickBack();
        longPressPage = sampleListPage.clickLongPress();
        longPressPage.performLongPress();
        String actual = driver.findElementByXPath("//android.widget.TextView[contains(@resource-id, 'message')]").getText();
        longPressPage.clickOk();
        assertEquals(actual,"you pressed me hard :P");
    }
}