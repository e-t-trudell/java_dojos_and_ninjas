package com.erictrudell.java_dojos_and_ninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erictrudell.java_dojos_and_ninjas.models.NinjaModel;
import com.erictrudell.java_dojos_and_ninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository ninjaRepo;
	public NinjaModel getOneNinja(Long id){
		return ninjaRepo.getOne(id);
	}
	public List<NinjaModel> getAllNinja(){
		return ninjaRepo.findAll();
	}
	public NinjaModel createNinja(NinjaModel e) {
		return ninjaRepo.save(e);
	}
	public NinjaModel updateNinja(NinjaModel e) {
		return ninjaRepo.save(e);
	}
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
