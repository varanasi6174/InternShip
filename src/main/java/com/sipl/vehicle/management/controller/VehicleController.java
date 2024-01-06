package com.sipl.vehicle.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle.management.entity.Vehicle;
import com.sipl.vehicle.management.service.VehicleService;
import com.sipl.vehicle.management.vehicleDTO.VehicleDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	//@Autowired
//	private VehicleMapper vehicleMapper;

	@PostMapping("/addVehicle")
	public ResponseEntity<Vehicle> saveVehicle(@Valid @RequestBody VehicleDTO VehicleDTO) {
		return new ResponseEntity<Vehicle>(vehicleService.createVehicle(VehicleDTO), HttpStatus.CREATED);
	}

	@GetMapping("/getVehicle/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") long id) {
		return new ResponseEntity<Vehicle>(vehicleService.getVehicleById(id), HttpStatus.OK);
	}

	@PutMapping("/editVehicle/{id}")
	public ResponseEntity<Vehicle> editVehicle(@Valid @PathVariable("id") long id, @RequestBody VehicleDTO VehicleDTO,
			Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(vehicleService.updateVehicle(id, VehicleDTO), HttpStatus.OK);
	}

	@DeleteMapping("/deleteVehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") long id) {
		vehicleService.deleteVehicle(id);
		return new ResponseEntity<String>("Deleted successfully....", HttpStatus.OK);
	}
}