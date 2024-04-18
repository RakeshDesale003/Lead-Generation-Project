package com.example.demo.lead.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LeadApiResponse {
	
	private String status;
    private Object data;

	
}
