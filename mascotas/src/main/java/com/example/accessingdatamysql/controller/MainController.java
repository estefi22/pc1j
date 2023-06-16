package com.example.accessingdatamysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.accessingdatamysql.model.Mascotas;
import com.example.accessingdatamysql.repo.MascotaRepository;

@Controller
@RequestMapping("/mascotas")
public class MainController {

	@Autowired private MascotaRepository repo;
	
	@GetMapping("/list")
	public @ResponseBody List<Mascotas> listar(){
		return (List<Mascotas>)repo.findAll();
	}
	
	@GetMapping("/buscar")
	public @ResponseBody Mascotas buscar(@RequestParam Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	@PostMapping("/agregar")
	public @ResponseBody String aregar(@RequestParam String nombre,@RequestParam String raza,@RequestParam String color){
		Mascotas mas=new Mascotas();
		mas.setNombre(nombre);
		mas.setColor(color);
		mas.setRaza(raza);
		repo.save(mas);
		
		return "Save";
	}
	
	@PutMapping("/update")
	public @ResponseBody String aregar(@RequestParam Integer id, @RequestParam String nombre,@RequestParam String raza,@RequestParam String color){
		Mascotas mas=new Mascotas();
		mas.setNombre(nombre);
		mas.setColor(color);
		mas.setRaza(raza);
		mas.setId(id);
		repo.save(mas);
		
		return "Actualizado";
	}
	
	@DeleteMapping("/eliminar")
	public @ResponseBody String aregar(@RequestParam Integer id) {
		repo.deleteById(id);
		return "eliminado";
	}
	
}
