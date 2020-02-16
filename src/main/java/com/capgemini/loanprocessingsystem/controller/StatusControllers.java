package com.capgemini.loanprocessingsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.loanprocessingsystem.dto.Status;
import com.capgemini.loanprocessingsystem.dto.StatusResponse;
import com.capgemini.loanprocessingsystem.service.StatusService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class StatusControllers {
	@Autowired
	StatusService statusService;
	@GetMapping(path="/view-status",produces=MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse viewAllstatus() {
		StatusResponse statusResponse=new StatusResponse();

		List<Status> list = statusService.getAllStatus();
		if(list.size()!=0) {
			statusResponse.setStatusCode(201);
			statusResponse.setMessage("Success");
			statusResponse.setDescription("Status found");
			statusResponse.setStatus(list);
		} else {
			statusResponse.setStatusCode(401);
			statusResponse.setMessage("Failure");
			statusResponse.setDescription("No data");
		}
		return statusResponse;
	}
	@PostMapping(path="/insert-status",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse addStatus(@RequestBody Status status) {
		StatusResponse response = new StatusResponse();
		if(statusService.insertStatus(status)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Status inserted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Status couldnt be inserted");
		}
		return response;

	}
	@DeleteMapping(path = "/delete-status/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse deleteStatus(@PathVariable("id") int id) {
		StatusResponse response = new StatusResponse();
		if(statusService.deleteStatus(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Status deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Status not found");
		}
		return response;
	}
	@GetMapping(path="/search-status/{statusId}", produces =MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse searchStatus(@PathVariable("statusId") int id) {
		StatusResponse statusResponse = new StatusResponse();
		Status status = statusService.searchStatus(id);
		if(status!=null) {
			statusResponse.setStatusCode(201);
			statusResponse.setDescription("Customer Found");
			statusResponse.setMessage("Success");
			statusResponse.setStatus(Arrays.asList(status));	

		}else {
			statusResponse.setStatusCode(401);
			statusResponse.setMessage("Failure");
			statusResponse.setDescription("Status with this Application Id doesn't exist");

		}
		return statusResponse;
	}
	@PutMapping(path = "/modify-status", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StatusResponse modifyStatus(@RequestBody Status status) {
		StatusResponse response = new StatusResponse ();
		if (statusService.modifyStatus(status .getStatusId(),status .getApplicationId(), 
				status.getStatus(),status.getLoanType())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Status updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Status not found");
		}
		return response;
	}
}
