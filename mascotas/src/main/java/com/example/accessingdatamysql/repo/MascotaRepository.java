package com.example.accessingdatamysql.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.accessingdatamysql.model.Mascotas;

@Component
public interface MascotaRepository extends CrudRepository<Mascotas, Integer>{

}
