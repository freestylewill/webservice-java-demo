package com.guigu.soap;

import com.guigu.service.impl.WeatherInterfaceImpl;

import javax.xml.ws.Endpoint;

/**
 * 3.  第三步：发布服务，Endpoint类发布服务，publish方法，两个参数：1.服务地址；2.服务实现类
 */
public class WeatherServer {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:12345/weather", new WeatherInterfaceImpl());
    }
}
