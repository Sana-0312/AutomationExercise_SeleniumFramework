package selenium.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.pageObjects.UserRegistration;

public class BaseTest {
	WebDriver driver;
	ChromeOptions options ;
	public UserRegistration loginPage;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\selenium\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			/*options = new ChromeOptions();
			options.addExtensions(new File("C:\\Users\\alasa\\seleniumTraining\\FrameworkProject\\Extensions\\AdBlock — best ad blocker 5.20.0.0.crx"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			capabilities.setCapability("disablePopupBlocking", true);
			options.addArguments("--disable-save-password-bubble");
			options.merge(capabilities);*/
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions opt1 = new EdgeOptions();
			opt1.addExtensions(new File("C:\\Users\\alasa\\seleniumTraining\\FrameworkProject\\Extensions\\AdBlock — best ad blocker 5.20.0.0.crx"));
			driver = new EdgeDriver(opt1);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}
	public List<HashMap<String, String>> getJasonData(String filePath) throws IOException
	{
		//read json and convert it into string
		String jasonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		//convert String to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jasonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	@BeforeMethod
	public UserRegistration launchApplication() throws IOException
	{
		driver = initializeDriver();
		loginPage = new UserRegistration(driver);
		loginPage.goTo();
		return loginPage;
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}

}
