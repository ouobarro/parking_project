package com.formation.parking.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Override
	public List<Parking> getListeParkings() {
		// TODO Auto-generated method stub
		
		Parking parkingTest = new Parking();
		parkingTest.setNom("parking de test");
		parkingTest.setNbPlacesTotal(300);
		parkingTest.setNbPlacesDispo(125);
		parkingTest.setStatut("FERMER");
		parkingTest.setHeureMaj("20h15");
		
		ArrayList<Parking> liste = new ArrayList<>();
		liste.add(parkingTest);
		return liste;
	}

}
