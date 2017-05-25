package com.example.weatherreport;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jdom.JDOMException;

import com.example.weatherreport.WeaterService;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
   private TextView s_city,s_weather,s_temp,s_wind,s_pm;
   private ImageView icon;
   private String city,weather,temp,wind,pm;
   List<WeatherInfo> info;
   WeatherInfo weatherInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        s_city=(TextView) findViewById(R.id.select_city);
        s_wind=(TextView) findViewById(R.id.wind);
        s_pm=(TextView) findViewById(R.id.pm);
        s_weather=(TextView)findViewById(R.id.select_weater);
        s_temp=(TextView)findViewById(R.id.temp);
        findViewById(R.id.bj).setOnClickListener(this);
        findViewById(R.id.jl).setOnClickListener(this);
        findViewById(R.id.sh).setOnClickListener(this);
        
        //接收info对象集合
        try {
 		 info=WeaterService.getWeatherInfos();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    public void getMap(int num){
    	 weatherInfo=(WeatherInfo) info.get(num);
    	 temp=weatherInfo.getTemp();
    	 pm=weatherInfo.getPm();
    	 wind=weatherInfo.getWind();
    	 city=weatherInfo.getName();
    	 weather=weatherInfo.getWeather();
    	 s_wind.setText("风力："+wind);
    	 s_pm.setText("PM:"+pm);
    	 s_city.setText(city);
    	 s_weather.setText(weather);
    	 s_temp.setText(temp);
    	 
    
    }
	@Override
	public void onClick(View g) {
		switch(g.getId()){
		case R.id.bj:
			getMap(1);
			break;
		case R.id.sh:
			getMap(0);
			break;
		case R.id.jl:
			getMap(2);
			break;
		}
		
	}


  
    
}
