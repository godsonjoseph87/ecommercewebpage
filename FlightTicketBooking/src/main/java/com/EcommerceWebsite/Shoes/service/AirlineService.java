package com.EcommerceWebsite.Shoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EcommerceWebsite.Shoes.util.JsonResponseUtil;

@Service
public class AirlineService {
	@Autowired
	public AirlineRepository airlineRepo;

	public Map<String, Object> getAllAirlines()
	{
		List<Airline> airline = new ArrayList<>();
		airlineRepo.findAll().forEach(airline::add);
		return JsonResponseUtil.createJsonResponse("Data fetched successfully", 200, airline);
	}

	public Map<String, Object> addAirline(Airline airline) {
		airlineRepo.save(airline);
		return JsonResponseUtil.createJsonResponse("Data Inserted successfully", 200, "");
	}

	public Map<String, Object> updateAirline(String id, Airline airline) {
		airlineRepo.save(airline);
		return JsonResponseUtil.createJsonResponse("Data Updated successfully", 200, "");
	}

	public Map<String, Object> deleteAirline(String id) {
		airlineRepo.deleteById(id);
		return JsonResponseUtil.createJsonResponse("Data Deleted successfully", 200, "");
	}
}
