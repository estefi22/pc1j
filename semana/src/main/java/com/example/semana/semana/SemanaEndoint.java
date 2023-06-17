package com.example.semana.semana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetWeekRequest;
import io.spring.guides.gs_producing_web_service.GetWeekResponse;

@Endpoint
public class SemanaEndoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	private SemanaReositorio data;
	
	@Autowired
	public SemanaEndoint(SemanaReositorio semana) {
		this.data=semana;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWeekRequest")
	@ResponsePayload
	public GetWeekResponse getCountry(@RequestPayload GetWeekRequest request) {
		GetWeekResponse response = new GetWeekResponse();
		response.setTraduccion(data.translateDay(request.getName().toLowerCase()));
		return response;
	}
	
}
