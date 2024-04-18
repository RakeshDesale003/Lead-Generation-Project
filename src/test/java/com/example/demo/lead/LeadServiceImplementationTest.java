package com.example.demo.lead;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

//import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.lead.controller.LeadController;
import com.example.demo.lead.exception.ErrorResponse;
import com.example.demo.lead.exception.LeadApiResponse;
import com.example.demo.lead.model.Gender;
import com.example.demo.lead.model.Lead;
import com.example.demo.lead.repository.LeadRepository;
import com.example.demo.lead.service.LeadService;
import com.example.demo.lead.serviceimp.LeadServiceImplementaion;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class LeadServiceImplementationTest {

		@InjectMocks
		private LeadServiceImplementaion leadServiceImp	;	
		@Mock
		private LeadRepository leadRepo;
		
		@Test
		public void getLeadByIdTest() {
			//Lead lead = createMockLead();
			
			when(( leadRepo.findByLeadId(1)).thenReturn(new Lead(1, "Rakesh", "", "Desale",
					"6077887788", Gender.Male, "22/09/1996", "rakesh@gmail.com")));
			Lead lead = leadServiceImp.getLeadById(1);
			assertEquals("1",lead.getLeadId());
			assertEquals("Rakesh",lead.getFirstName());
			assertEquals("",lead.getMiddleName());
			assertEquals("Desale",lead.getLastName());
			assertEquals("6077887788",lead.getMobileNumber());
			assertEquals(Gender.Male,lead.getGender());
			assertEquals("22/09/1996",lead.getDob());
			assertEquals("rakesh@gmail.com",lead.getEmail());
		}
		
		
		
		
		
		
		
		/* 
	@Test
		
		public void createLeadTest() throws Exception  {
			Lead lead = createMockLead();
			// LeadApiResponse  leads = new LeadApiResponse("success", "Created Leads Successfully");
			when(leadServiceImp.saveLead(lead)).thenReturn(lead );
			
			assertEquals(leads, leadController.createLead(lead));
	
			 when(leadServiceImp.saveLead(createMockLead()))
             .thenReturn(new LeadApiResponse("error", new ErrorResponse("E10010", "Lead Already Exists in the database with the lead id")));

     mockMvc.perform(MockMvcRequestBuilders.post("/Lead/save")
            .contentType(MediaType.APPLICATION_JSON)
             .content("{ \"leadId\": 5678, \"firstName\": \"Vineet\", \"middleName\": \"Bharat\", \"lastName\": \"Desale\", \"mobileNumber\": \"8877887788\", \"gender\": \"Gender.Male\", \"dob\": \"22/09/1996\", \"email\": \"rakeshdesale4@gmail.com\" }"))
     		.andExpect(status().isOk())
     		.andExpect(jsonPath("$.status").value("success"))
     		.andExpect(jsonPath("$.data").value("Created Leads Successfully"));
}
		
		


	@Test
	public void saveLeadTest() {
		  Lead lead = createMockLead();
	        when(leadRepo.existsByLeadId(lead.getLeadId())).thenReturn(false);

	        LeadApiResponse response = leadService.saveLead(lead);

	        assertEquals("success", response.getStatus());
	    //    assertNull(( response).getErrorResponse());
	        verify(leadRepo, times(1)).save(lead);
	    }
	*/

	
	private Lead createMockLead() {
		Lead lead = new Lead(1, "Rakesh", null, "Desale", "'6077887788'", Gender.Male, "22/09/1996", "rakesh@gmail.com");
        return lead;	
	}


	    
	
	
	
}
