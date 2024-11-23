package com.edubridge.app4.service;

import java.util.ArrayList;
import java.util.List;
import com.edubridge.app4.model.Aircooler;

public class AircoolerService {
	    private List<Aircooler> aircoolerList = new ArrayList<>();
	 // Add Air cooler
	    public void addAircooler(Aircooler aircooler) {
	    	aircoolerList.add(aircooler);
	        System.out.println("Aircooler added successfully");
	    }

	    // Get all Air coolers
	    public List<Aircooler> getAllAircoolers() {
	        return aircoolerList;
	    }

	    // Get Air cooler by id
	    public Aircooler getAircoolerById(int id) {
	        for (Aircooler aircooler : aircoolerList) {
	            if (aircooler.getId() == id) {
	                return aircooler;
	            }
	        }
	        return null;
	    }

	    // Update Air cooler
	    public void updateAircooler(Aircooler aircooler) {
	        for (int i = 0; i < aircoolerList.size(); i++) {
	            if (aircoolerList.get(i).getId() == aircooler.getId()) {
	            	aircoolerList.set(i, aircooler);
	                System.out.println("Aircooler updated successfully");
	                return;
	            }
	        }
	        System.out.println("Aircooler not found");
	    }

	    // Delete Air cooler by id
	    public void deleteAircooler(int id) {
	    	aircoolerList.removeIf(aircooler -> aircooler.getId() == id);
	        System.out.println("Aircooler deleted successfully");
	    }

	    // Delete all Air coolers
	    public void deleteAllAircoolers() {
	    	aircoolerList.clear();
	        System.out.println("All Aircoolers deleted");
	    }

}
