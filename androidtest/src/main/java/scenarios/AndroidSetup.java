package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class AndroidSetup {
    private static volatile AndroidSetup instance;
    protected AndroidDriver driver;

    private AndroidSetup() {

    }

    protected void prepareAndroidForAppium() {
        File appDir = new File(System.getProperty("user.dir"),"../apps");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", "com.vodqareactnative");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("deviceName", "Android");
        driver =  new AndroidDriver(capabilities);
    }

    public static AndroidSetup getInstance() {
        AndroidSetup localInstance = instance;
        if (localInstance == null) {
            synchronized (AndroidSetup.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new AndroidSetup();
                    localInstance.prepareAndroidForAppium();
                }
            }
        }
        return localInstance;
    }

    public AndroidDriver getDriver() {
        if(driver == null) {
            prepareAndroidForAppium();
        }
        return driver;
    }
}
