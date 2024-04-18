package com.example.demo.lead.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.lead.exception.LeadApiResponse;
import com.example.demo.lead.model.Lead;
import com.example.demo.lead.service.LeadService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping("/Lead")
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@GetMapping("/hi")
	public String welcome() {
		return "Welcome Lead..";
	}
	
	@PostMapping("/save")
	public ResponseEntity<LeadApiResponse> createLead( @Valid @RequestBody  Lead lead) {
		LeadApiResponse leads = leadService.saveLead(lead);
		return   ResponseEntity.ok().body(leads);
	}
	
	@GetMapping("/getLead/{mobileNumber}")
	public ResponseEntity<LeadApiResponse> getLeadByMobileNumber(@PathVariable @NotBlank 	@Pattern(regexp = "^[6-9]\\d{9}$") String mobileNumber ){
		LeadApiResponse number = leadService.getLeadByMobileNumber(mobileNumber);
		return ResponseEntity.ok().body(number);
	}
	
	@GetMapping("/getId/{id}")
	public ResponseEntity<Lead> getLead(@PathVariable Integer id){
		Lead leadId = leadService.getLeadById(id);
		return ResponseEntity.ok().body(leadId);
	}
	
}
