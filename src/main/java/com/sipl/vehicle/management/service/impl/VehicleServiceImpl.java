package com.sipl.vehicle.management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sipl.vehicle.management.entity.Vehicle;
import com.sipl.vehicle.management.exception.VehicleIdNotFoundException;
import com.sipl.vehicle.management.mapper.VehicleMapper;
import com.sipl.vehicle.management.repository.VehicleRepository;
import com.sipl.vehicle.management.service.VehicleService;
import com.sipl.vehicle.management.vehicleDTO.VehicleDTO;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehiclerepo;
	@Autowired
	private VehicleMapper vehicleMapper;

	public void VehicleService(VehicleRepository vehiclerepo) {
		this.vehiclerepo = vehiclerepo;
	}

	@Override
	public Vehicle createVehicle(VehicleDTO vehicleDto) {
		Vehicle vehicle = vehicleMapper.mapVehicleDTOToVehicle(vehicleDto);
		return vehiclerepo.save(vehicle);
	}

	@Override
	public Vehicle getVehicleById(Long id) {
		return vehiclerepo.findById(id).orElseThrow(() -> new VehicleIdNotFoundException("Vehicle Id is not correct"));
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehiclerepo.findAll();

	}

	@Override
	public Vehicle updateVehicle(Long id, VehicleDTO vehicleDto) {
		Vehicle updatedVehicle = vehiclerepo.findById(id)
				.orElseThrow(() -> new VehicleIdNotFoundException("Vehicle Id is not correct"));

		updatedVehicle.setOwnerName(vehicleDto.getOwnerName());

		vehiclerepo.save(updatedVehicle);
		return updatedVehicle;

	}

	@Override
	public void deleteVehicle(Long id) {
		vehiclerepo.findById(id).orElseThrow(() -> new VehicleIdNotFoundException("Vevicle Id is not correct"));
		vehiclerepo.deleteById(id);

	}

}
