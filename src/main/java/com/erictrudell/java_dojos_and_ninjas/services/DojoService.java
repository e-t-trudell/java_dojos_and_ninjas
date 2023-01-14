package com.erictrudell.java_dojos_and_ninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erictrudell.java_dojos_and_ninjas.models.DojoModel;
import com.erictrudell.java_dojos_and_ninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepo;
	public DojoModel getOneDojo(Long id){
		return dojoRepo.getOne(id);
	}
	public List<DojoModel> getAllDojos(){
		return dojoRepo.findAll();
	}
	public DojoModel createDojo(DojoModel e) {
		return dojoRepo.save(e);
	}
	public DojoModel updateDojo(DojoModel e) {
		return dojoRepo.save(e);
	}
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
