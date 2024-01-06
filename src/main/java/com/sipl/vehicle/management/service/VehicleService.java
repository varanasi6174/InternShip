package com.sipl.vehicle.management.service;

import java.util.List;

import com.sipl.vehicle.management.entity.Vehicle;
import com.sipl.vehicle.management.vehicleDTO.VehicleDTO;

public interface VehicleService {
	
	Vehicle createVehicle(VehicleDTO vehicleDto);

	Vehicle getVehicleById(Long id);

	List<Vehicle> getAllVehicles();

	Vehicle updateVehicle(Long id, VehicleDTO vehicleDto);

	void deleteVehicle(Long id);

}
