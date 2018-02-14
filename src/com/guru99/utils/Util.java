package com.guru99.utils;

public class Util {
	
	public static String fireFoxDriverPath="./browser-server/"+"geckodriver.exe";
	public static String baseUrl="http://www.demo.guru99.com/V4/";
	public static String uid=GetData.fromExcel("Login_Data", "Login", 2, 0);
	public static String pwd=GetData.fromExcel("Login_Data", "Login", 2, 1);
	
}
