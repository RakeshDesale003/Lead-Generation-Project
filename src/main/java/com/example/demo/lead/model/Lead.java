package com.example.demo.lead.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@ToString
//@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Lead_Generation")
	public class Lead {


	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LeadId")
	private long leadId;
	
	@NotNull
	@Pattern(regexp="^[A-Z][a-z]+$", message = " First letter should start with Uppercase.")
	@Column(name="FirstName")
	private String firstName;

	@Column(name="MiddleName")
	private String middleName;
	
	@NotNull
	@Pattern(regexp="^[A-Z][a-z]+$", message = " First letter should start with Uppercase.")
	@Column(name="LastName")
	private String lastName;
	
    @NotNull
	@Pattern(regexp = "^[6-9]\\d{9}$" , message = "Enter Valid 10 digit mobile number.")
	@Column(name="MobileNumber")
	private String mobileNumber;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="Gender")
	private Gender gender;
	
	@NotNull
	@Pattern(regexp = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9]{4})$",
	message = "DOB should be in following format 22/09/19966")
	@Column(name="DOB")
	private String dob;
		
	@NotNull
	@Email
	@Column(name="Email")
	private String email;

	

	public long getLeadId() {
		return leadId;
	}

	public void setLeadId(long leadId) {
		this.leadId = leadId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Lead [leadId=" + leadId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", mobileNumber=" + mobileNumber + ", gender=" + gender + ", dob=" + dob + ", email="
				+ email + "]";
	}

	public Lead(long leadId,
			@NotNull @Pattern(regexp = "^[A-Z][a-z]+$", message = " First letter should start with Uppercase.") String firstName,
			String middleName,
			@NotNull @Pattern(regexp = "^[A-Z][a-z]+$", message = " First letter should start with Uppercase.") String lastName,
			@NotNull @Pattern(regexp = "^[6-9]\\d{9}$", message = "Enter Valid 10 digit mobile number.") String mobileNumber,
			@NotNull Gender gender,
			@NotNull @Pattern(regexp = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9]{4})$", message = "DOB should be in following format 22/09/19966") String dob,
			@NotNull @Email String email) {
		super();
		this.leadId = leadId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
	}


	



	



}
