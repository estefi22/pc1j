package com.example.semana.semana;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Week;
import jakarta.annotation.PostConstruct;

@Component
public class SemanaReositorio {

	private static final Map<String, Week> semana = new HashMap<>();
	
	@PostConstruct
	public void initData() {
		Week dia1=new Week();
		dia1.setName("Lunes");
		dia1.setTraduccion("Monday");
		semana.put("lunes", dia1);
		
		Week dia2=new Week();
		dia2.setName("Martes");
		dia2.setTraduccion("Tuesday");
		semana.put("martes", dia2);
		
		Week dia3=new Week();
		dia3.setName("Miercoles");
		dia3.setTraduccion("Wednesday");
		semana.put("miercoles", dia3);
		
		Week dia4=new Week();
		dia4.setName("Jueves");
		dia4.setTraduccion("Thursday");
		semana.put("jueves", dia4);

		Week dia5=new Week();
		dia5.setName("Viernes");
		dia5.setTraduccion("Friday");
		semana.put("viernes", dia5);
		
		Week dia6=new Week();
		dia6.setName("Sabado");
		dia6.setTraduccion("Saturday");
		semana.put("sabado", dia6);
		
		Week dia7=new Week();
		dia7.setName("Domingo");
		dia7.setTraduccion("Sunday");
		semana.put("domingo", dia7);
		
	}
	
	public String translateDay(String nombre) {
		Assert.notNull(nombre, "Nulo");
		return semana.get(nombre).getTraduccion();
	}
	
	
}
