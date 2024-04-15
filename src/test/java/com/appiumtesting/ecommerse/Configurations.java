package com.appiumtesting.ecommerse;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Configurations {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void appiumSetUp() throws MalformedURLException, URISyntaxException {


		// set up to start the Appium Server Programmatically
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//SUMAHALI//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		//start the server
		service.start();

		//Capabilities -- set the device informations
		UiAutomator2Options options = new UiAutomator2Options();

		// SundarrajMobile -- device name in Android Studio
		options.setDeviceName("SundarrajMobile");

		// give the path of the APP you want to test
		options.setApp("C://Users//SUMAHALI//eclipse-workspace//Appium//src//test//java//Resource//General-Store.apk");
		
		//chrome driver set up 
		options.setChromedriverExecutable("C://Users//SUMAHALI//eclipse-workspace//Appium//src//test//java//Resource//chromedriver.exe");

		// Appium driver setup
		//"http://192.168.1.101:4723" -- Appium Server Url
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options );
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {

		//closs the app
		driver.quit();

		// stop the appium server
		service.stop();
	}

}
