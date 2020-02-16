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

import com.capgemini.loanprocessingsystem.dto.Verification;
import com.capgemini.loanprocessingsystem.dto.VerificationResponse;
import com.capgemini.loanprocessingsystem.service.VerificationService;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class VerificationController {
	
     @Autowired
	 VerificationService verificationService;

	@GetMapping(path="/view-verfications",produces=MediaType.APPLICATION_JSON_VALUE)
	public VerificationResponse viewAllVerifications() {
		VerificationResponse verificationResponse=new VerificationResponse();

		List<Verification> list = verificationService.getAllVerification();
		if(list.size()!=0) {
			verificationResponse.setStatusCode(201);
			verificationResponse.setMessage("Success");
			verificationResponse.setDescription("Customers found");
			verificationResponse.setVerification(list);
		} else {
			verificationResponse.setStatusCode(401);
			verificationResponse.setMessage("Failure");
			verificationResponse.setDescription("No data");
		}
		return verificationResponse;


	}
	@PostMapping(path="/insert-verification",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public VerificationResponse addVerification(@RequestBody Verification verification) {
		VerificationResponse response = new VerificationResponse();
		if(verificationService.insertVerification(verification)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Verified");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Verification couldnt be done");
		}
		return response;

	}
	@DeleteMapping(path = "/delete-verification/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public VerificationResponse deleteVerification(@PathVariable("id") int id) {
		VerificationResponse response = new VerificationResponse();
		if(verificationService.deleteVerification(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Verification deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Verification not found");
		}
		return response;
}
	@GetMapping(path = "/view-Verification/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public VerificationResponse getVerification(@PathVariable("id") int id) {
		VerificationResponse response = new VerificationResponse ();
		Verification verification = verificationService.searchVerification(id);
		if (verification != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Verification found");
			response.setVerification(Arrays.asList(verification));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Verification id does not exist");
		}
		return response;
	}
	@PutMapping(path = "/modify-verification", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public VerificationResponse modifyVerification(@RequestBody Verification verification) {
		VerificationResponse response = new VerificationResponse ();
		if (verificationService.modifyVerification(verification .getVerificationId(),verification .getApplicationId(), verification .getInterviewDate(),
				verification.getStatus(),verification.getLoanType())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Verification updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Verification not found");
		}
		return response;
	}

}
