package com.edubridge.app4.service;

import java.util.List;

import com.edubridge.app4.model.Aircooler;

public interface AircoolerServiceI {
	void addAircooler(Aircooler aircooler);
	List<Aircooler> getAllAircoolers();	
	Aircooler getAircoolerById(Integer id);
	void updateAircooler(Aircooler aircooler);
	void deleteAircooler(Integer id);
	void deleteAllAircoolers();
}
