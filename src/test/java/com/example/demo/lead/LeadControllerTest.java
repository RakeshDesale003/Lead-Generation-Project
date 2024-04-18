package com.example.demo.lead;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.lead.controller.LeadController;
import com.example.demo.lead.exception.ErrorResponse;
import com.example.demo.lead.exception.LeadApiResponse;
import com.example.demo.lead.model.Gender;
import com.example.demo.lead.model.Lead;
import com.example.demo.lead.serviceimp.LeadServiceImplementaion;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Lead.class)
@WebMvcTest(LeadController.class)
@DataJpaTest
public class LeadControllerTest {

	@Autowired
    private MockMvc mockMvc;

	//@InjectMocks
	@MockBean
	private LeadController leadController;
	
	//private LeadServiceImplementaion leadServiceImp	;	
	 @Autowired
	  private ObjectMapper objectMapper;
	 
	
	//@Test
	 void createLeadTest()   throws Exception  {
		// when(leadServiceImp.saveLead(createMockLead()))
       //  .thenReturn(new LeadApiResponse("error", new ErrorResponse("E10010", "Lead Already Exists in the database with the lead id")));
		 Lead lead =  createMockLead();
		 
        mockMvc.perform(MockMvcRequestBuilders.post("/Lead/save")
         .contentType(MediaType.APPLICATION_JSON)
         .content("{ \"leadId\": 5678, \"firstName\": \"Vineet\", \"middleName\": \"Bharat\", \"lastName\": \"Desale\", \"mobileNumber\": \"8877887788\", \"gender\": \"Gender.Male\", \"dob\": \"22/09/1996\", \"email\": \"rakeshdesale4@gmail.com\" }"))
   
        //  .content(objectMapper.writeValueAsString(lead)))
      //  when()
         .andExpect(status().isOk())
 		.andExpect(jsonPath("$.status").value("success"))
 		.andExpect(jsonPath("$.data").value("Created Leads Successfully"));
}
	
	
	
	 private Lead createMockLead() {
			Lead lead = new Lead(5678, "Vineet", "Bharat", "Desale", "8877887788", Gender.Male, "22/09/1996", "rakeshdesale4@gmail.com");
	        return lead;	
		}
	
	
	
}
