package com.guigu.internet.soap;

import com.guigu.internet.weather.ArrayOfString;
import com.guigu.internet.weather.WeatherWebService;
import com.guigu.internet.weather.WeatherWebServiceSoap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 
 * <p>Title: ServiceClient.java</p>
 * <p>Description:Service编程实现服务端调用</p>
 * <p>Company: www.itcast.com</p>
 * @author  传智.at
 * @date    2015年11月26日下午3:43:55
 * @version 1.0
 */
public class ServiceClient {

	public static void main(String[] args) throws IOException {
		String addrString = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
		//创建WSDL的URL，注意不是服务地址
		URL url = new URL(addrString);
		
		//创建服务名称
		//1.namespaceURI - 命名空间地址
		//2.localPart - 服务视图名
		QName qname = new QName("http://WebXml.com.cn/", "WeatherWebService");
		
		//创建服务视图
		//参数解释：
		//1.wsdlDocumentLocation - wsdl地址
		//2.serviceName - 服务名称
		Service service = Service.create(url, qname);
		//获取服务实现类
		WeatherWebServiceSoap weatherWebServiceSoap = service.getPort(WeatherWebServiceSoap.class);
		//调用查询方法
		ArrayOfString arrayOfString = weatherWebServiceSoap.getWeatherbyCityName("长沙");
		List<String> list = arrayOfString.getString();

		for(String str : list){
			System.out.println(str);
		}
	}
}
