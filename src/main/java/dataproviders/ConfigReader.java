package dataproviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	
	public static String getValue(String key)
	{
		String value=null;
		
		try {
			Properties pro=new Properties();
			
			FileInputStream fis=new FileInputStream("./Config/config.properties");
			
			pro.load(fis);
			
			value = pro.getProperty(key);
			
		} catch (FileNotFoundException e) 
		{
			System.out.println("Could not find the file "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not load the file "+e.getMessage());
		}
		
		return value;
	}
	
	

}
