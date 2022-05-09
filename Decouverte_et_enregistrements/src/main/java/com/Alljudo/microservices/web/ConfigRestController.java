package com.Alljudo.microservices.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigRestController {
	
	@Value("${yParam}")
	private int yParam;
	@Value("${xParam}")
	private int xParam;
	@Value("${eureka.client.serviceUrl.defaultZone}")
	private String lien;
	@GetMapping(path="/showConfig")
	public Map<String,Object> showConfig(){
		Map<String,Object> params=new HashMap<>();
		params.put("lien", lien);
		params.put("yParam", yParam);
		params.put("xParam", xParam);
		params.put("threadName", Thread.currentThread().getName());
		return params;
		
	}
}
