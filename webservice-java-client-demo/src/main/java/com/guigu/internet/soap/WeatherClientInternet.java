package com.guigu.internet.soap;

import com.guigu.internet.weather.ArrayOfString;
import com.guigu.internet.weather.WeatherWebService;
import com.guigu.internet.weather.WeatherWebServiceSoap;

import java.util.List;

/**
 * 
 * <p>Title: WeatherClient.java</p>
 * <p>Description:公网天气查询客户端</p>
 * <p>Company: www.itcast.com</p>
 * @author  传智.at
 * @date    2015年11月26日下午3:24:12
 * @version 1.0
 */
public class WeatherClientInternet {

	public static void main(String[] args) {
		WeatherWebService weatherWS = new WeatherWebService();
		WeatherWebServiceSoap weatherWSSoap = weatherWS.getPort(WeatherWebServiceSoap.class);
		ArrayOfString arrayOfString222 = weatherWSSoap.getSupportProvince();
		System.err.println(arrayOfString222.getString());
		ArrayOfString arrayOfString = weatherWSSoap.getWeatherbyCityName("长沙");
		List<String> list = arrayOfString.getString();
		
		for(String str : list){
			System.out.println(str);
		}
	}
}
