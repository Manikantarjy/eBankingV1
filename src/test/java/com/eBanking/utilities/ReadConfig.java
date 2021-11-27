package com.eBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	//Create a constructor for Reading config
	public ReadConfig()
	{
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is " +e.getMessage());
		}	
	}
//To read all the config details below methods has to be created

	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}


	public String getUserName()
	{
		String username = pro.getProperty("username");
		return username;
	}
	

	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getfirefoxPath()
	{
		String firefoxPath = pro.getProperty("firefoxpath");
		return firefoxPath;
	}
	
	public String getEdgePath()
	{
		String edgePath = pro.getProperty("edgepath");
		return edgePath;
	}
	
	
	
	
	
}
