package com.example.demo.lead.service;

import com.example.demo.lead.exception.LeadApiResponse;
import com.example.demo.lead.model.Lead;

public interface LeadService {

	public LeadApiResponse saveLead(Lead lead);

	public LeadApiResponse getLeadByMobileNumber(String mobileNumber);

	public Lead getLeadById(Integer id);

}
