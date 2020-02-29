package com.airtel.mdm.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.airtel.mdm.auditable.Auditable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PolicyDto extends Auditable<String>{
	
	private String policyName;
	private Long policyId;
	private String status;
	
	private Boolean isMandatory;
	
	private Integer maximumFailedAttempts;
	
	private Integer lastPassCode;
	
	private Boolean isMuteSpeakerOrMicrophone;

	private String description;
	
	private Integer maximumPassCodeAge;

	//passcode policy is comming by select from UI
	private String passCodePolicy;
	
	private Boolean isBootModeRequired;
	
	private String networkManagementConfig;
	
	/*
	 * private String appId;
	 * 
	 * private String appName;
	 * 
	 * private String appType;
	 * 
	 * private String packageName;
	 * 
	 * public boolean action;
	 */
	
	
	
	
	
	
	
	
	

	
	

}
