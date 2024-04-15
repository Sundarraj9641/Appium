package com.appiumtesting.Appium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


public class AppPackageAndActivity extends AppiumConfiguration {

	@Test
	public void appPackageAndActivityDemo() throws InterruptedException {
		
//		adb devices
//		adb shell
//		dumpsys window displays | grep -E “mCurrentFocus"

		
		//intent -- package + activity
		//io.appium.android.apis/io.appium.android.apis.preference.DefaultValues -- package/activity
	    ((JavascriptExecutor)driver).executeScript("mobile: startActivity", 
	    		ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.preference.DefaultValues"));
	
	    Thread.sleep(2000);
	}
}
