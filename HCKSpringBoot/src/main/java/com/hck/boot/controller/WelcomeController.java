package com.hck.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	@RequestMapping("/citySeacrh")
	public String citySeacrh(Map<String, Object> model,HttpServletResponse httpServletResponse) {
		
		return "welcome";
	}
	
	@RequestMapping("/findByCityName")
	@ResponseBody
	public ArrayList findByCityName(@RequestParam("cityName") String cityName,HttpServletResponse httpServletResponse) {
		//System.out.println("$$$$$$$$$$---cityName--$$$$$$$$$$"+cityName);
        RestTemplate restTemplate = new RestTemplate();
        HashMap quote = restTemplate.getForObject("URL"+cityName+".json", HashMap.class);
       // System.out.println("---quote---"+quote.get("response"));
        HashMap response = new HashMap();
        response=(HashMap)quote.get("response");
       // System.out.println("---results---"+response.get("results"));
        ArrayList aList=(ArrayList) response.get("results");
       // System.out.println("---aList---"+aList.size());
        httpServletResponse.setContentType(""+aList);
        httpServletResponse.setStatus(200);
		return aList;
	}
}