package com.virtusa.demo;

import net.webservicex.GetCitiesByCountryResponse;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import org.junit.Test;

public class CXFTest {
	
	@Test
	public void testCxf(){
		GlobalWeather weather = new GlobalWeather();
		GlobalWeatherSoap resp = weather.getGlobalWeatherSoap();
		String cities = resp.getCitiesByCountry("india");
		System.out.println(cities);
	}

}
