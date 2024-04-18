package com.example.demo.lead.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.lead.exception.ErrorResponse;
import com.example.demo.lead.exception.LeadApiResponse;
import com.example.demo.lead.model.Lead;
import com.example.demo.lead.repository.LeadRepository;
import com.example.demo.lead.service.LeadService;

import jakarta.validation.Valid;

@Service
public class LeadServiceImplementaion implements LeadService {

	@Autowired
	private LeadRepository leadRepo;

	@Override
	public LeadApiResponse saveLead( Lead lead) {
		if (leadRepo.existsByLeadId(lead.getLeadId())) {
			return new LeadApiResponse("error", new ErrorResponse("E10010",
					"Lead Already Exists in the database with the lead id = " + lead.getLeadId()));
		}

		leadRepo.save(lead);
		return new LeadApiResponse("success", "Created Leads Successfully");
	}

	@Override
	public LeadApiResponse getLeadByMobileNumber(String mobileNumber) {
		List<Lead> leads = leadRepo.findByMobileNumber(mobileNumber);
		if (leads.isEmpty()) {
			return new LeadApiResponse("error",
					new ErrorResponse("E10011", "No Lead found with the Mobile Number " + mobileNumber));
		}
		return new LeadApiResponse("sucess", leads);
	}


	@Override
	public Lead getLeadById(Integer id) {
		return leadRepo.findByLeadId(id);

	}
	
	

}
