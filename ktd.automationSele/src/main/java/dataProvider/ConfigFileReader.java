package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

		private Properties properties;
		private final String propertiesFilePath="configs//Configuration.properties";
		
		public ConfigFileReader(){
			BufferedReader reader;
			try {
				reader= new BufferedReader(new FileReader(propertiesFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties is not found at "+propertiesFilePath);
			}	
		}
		
		public String getDriverPath() {
			String driverPath=properties.getProperty("driverPath");
			if(driverPath!=null) 
				return driverPath;
			else
				throw new RuntimeException("driverPath not specified in Configuraion.properties");		
		}
		
		public long getImplicityWait() {
			String implicityWait= properties.getProperty("implicityWait");
			if(implicityWait!=null)
				return Long.parseLong(implicityWait);
			else
				throw new RuntimeException("implicityWait not found in Configuration.properties");
		}
		public 	String getUrl() {
			
			String url= properties.getProperty("url");
			if(url!=null)
				return url;
			else throw new RuntimeException("url not specified in Configuration.properties");
		}
		public DriverType getBrowser() {
			String browserName = properties.getProperty("browser");
			if(browserName.equals("chrome"))
				return DriverType.CHROME;
			else if (browserName.equals("firefox"))
				return DriverType.FIREFOX;
			else if (browserName.equals("iexplorer"))
				return DriverType.INTERNETEXPLORER;
			else
				throw new RuntimeException("not have any config about webdriver");
			}
		public EnvironmentType getEnvironment() {
			String environmentName =properties.getProperty("environment");
			if(environmentName.equalsIgnoreCase("local"))
				return EnvironmentType.LOCAL;
			else if (environmentName.equals("remote"))
				return EnvironmentType.REMOTE;
			else 
				throw new RuntimeException("not have any environment type");
		}
		public Boolean getBrowserWindowSize() {
			String windowSize= properties.getProperty("windowsMaximize");
			if(windowSize!=null) return Boolean.valueOf(windowSize);
			else return true;
		}
		public String getTestDataResourcePath(){
			String testDataResourcePath = properties.getProperty("testDataResourcePath");
			if(testDataResourcePath!= null) return testDataResourcePath;
			else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");		
		}
			
}
