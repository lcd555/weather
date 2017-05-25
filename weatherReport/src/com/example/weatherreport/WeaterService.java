package com.example.weatherreport;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class WeaterService {
	private static int id;
	private static String name, weather, temp, pm, wind,w="weather.xml";
		  public static List<WeatherInfo> getWeatherInfos() throws JDOMException, IOException{
			  List<WeatherInfo>weatherInfos=new ArrayList<WeatherInfo>();
			  WeatherInfo weatherInfo=null;
			  
			  //jdom解析xml
			  SAXBuilder aBuilder=new SAXBuilder();
			  Document document=aBuilder.build(MainActivity.class.getClassLoader().getResourceAsStream("weather.xml"));
			  Element root=document.getRootElement();
			  List lt=root.getChildren("city");
			  int i=0;
			  //获得weatherinfo存入集合
			  while(i<3){
				  //遍历每个城市给weatherinfo赋值
				  for(int j=0;j<lt.size();j++){
					  Element e=(Element)lt.get(j);
					  if(e.getAttributeValue("id").equals(i+"")){
						  weatherInfo=new WeatherInfo();
						 name=e.getChildText("name");
						 weather=e.getChildText("weather");
						 pm=e.getChildText("pm");
						 temp=e.getChildText("temp");
						 wind=e.getChildText("wind");
						 weatherInfo.setName(name);
						 weatherInfo.setPm(pm);
						 weatherInfo.setId(i);
						 weatherInfo.setTemp(temp);
						 weatherInfo.setWind(wind);
						 weatherInfo.setWeather(weather);
						 weatherInfos.add(weatherInfo);
						 break;
					  }
					  
				  }
				  i++;
			  }
			  
			  
			  return weatherInfos;
		  }
				  
		  
}
