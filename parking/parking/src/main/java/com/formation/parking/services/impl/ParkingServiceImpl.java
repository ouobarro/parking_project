package com.formation.parking.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.parking.dao.ParkingAPIDAO;
import com.formation.parking.dao.entity.RecordEntity;
import com.formation.parking.dao.entity.ResponseParkingAPIEntity;
import com.formation.parking.models.Parking;
import com.formation.parking.services.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {
	
	@Autowired 
	private ParkingAPIDAO parkingAPIDAO;

	@Override
	public List<Parking> getListeParkings() {
		// TODO Auto-generated method stub
		ResponseParkingAPIEntity response = parkingAPIDAO.getListeParkings();
		
		return transformEntityToModel(response);
	}

	private List<Parking> transformEntityToModel(ResponseParkingAPIEntity response) {
		// TODO Auto-generated method stub
		
		List<Parking> resultat = new ArrayList<Parking>();
		
		for (RecordEntity record : response.getRecords()) {
			Parking parking = new Parking();
			parking.setNom(record.getFields().getGrpNom());
			parking.setStatut(record.getFields().getGrpStatut());
			parking.setNbPlacesTotal(record.getFields().getGrpExploitation());
			parking.setNbPlacesDispo(record.getFields().getDisponibilite());
			resultat.add(parking);
		}
		return resultat;
	}

}
