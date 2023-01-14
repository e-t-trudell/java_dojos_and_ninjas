package com.erictrudell.java_dojos_and_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erictrudell.java_dojos_and_ninjas.models.DojoModel;


public interface DojoRepository extends CrudRepository<DojoModel, Long>{
	List<DojoModel> findAll();
	DojoModel getOne(Long id);
	List<DojoModel> save(String e);
}
