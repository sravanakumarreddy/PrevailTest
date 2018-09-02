package com.prevail.utilgeneric;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileEmulation {

	
	void mobEmu()
	{
		/*	//set mobile emulation for existing devices
		HashMap<String,String> mobEmul=new HashMap<String, String>();
		mobEmul.put("deviceName", "Google Nexus 5");
		
		HashMap<String, Object> chromeOptions=new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobEmul);
		
		// or
		
		//ChromeOptions c=new ChromeOptions();
		//c.setExperimentalOption("mobileEmulation", mobEmul);
		
		DesiredCapabilities des=new DesiredCapabilities();
		des.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		des.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		des.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(des);
		driver.get("http://www.google.com");*/
		
		
		//set custom mobile emulation
		
		Map<String, Object> deviceMetrics = new HashMap<String, Object>();
		deviceMetrics.put("width", 360);
		deviceMetrics.put("height", 640);
		deviceMetrics.put("pixelRatio", 3.0);
		
		
		Map<String, Object> mobileEmulation = new HashMap<String, Object>();
		mobileEmulation.put("deviceMetrics", deviceMetrics);
		mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
		
		Map<String, Object> chromeOption = new HashMap<String, Object>();
		chromeOption.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOption);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver(capabilities);
		driver1.get("https://development.elizabetharden.pfsweb.demandware.net/on/demandware.store/Sites-ElizabethArden-Site/default");
	}
	
}
