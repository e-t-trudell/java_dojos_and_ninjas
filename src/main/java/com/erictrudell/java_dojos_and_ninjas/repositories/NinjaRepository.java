package com.erictrudell.java_dojos_and_ninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erictrudell.java_dojos_and_ninjas.models.NinjaModel;

public interface NinjaRepository extends CrudRepository<NinjaModel, Long> {
	List<NinjaModel> findAll();
	NinjaModel getOne(Long id);
	List<NinjaModel> save(String e);
}
