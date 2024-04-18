package com.example.demo.lead.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.lead.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

	
	public List<Lead> findByMobileNumber(String mobileNumber);

	public boolean existsByLeadId(long leadId);

	public Lead findByLeadId(Integer id);

	


	

}
