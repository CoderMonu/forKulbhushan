package com.airtel.mdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.mdm.dto.PolicyDto;
import com.airtel.mdm.entity.Policy;
import com.airtel.mdm.service.PolicyService;

@RestController
public class PolicyController {
	
	@Autowired
	PolicyService policyService;
	
	
	
	@RequestMapping(value="/createPolicy")
	public Policy createPolicy(PolicyDto policyDto) {
		//update existing policy
		/*
		 * if(policyDto.getPolicyId()!=0l) { Policy policy=new Policy();
		 * policy.setAppId(policyDto.getAppId());
		 * policy.setAppName(policyDto.getAppName());
		 * policy.setAppType(policyDto.getAppType());
		 * policy.setDescription(policyDto.getDescription());
		 * 
		 * }
		 */
		//create new policy 
		if(policyDto.getPolicyId().equals(null)) {
			
			Policy p=new Policy();
			   
		}else {
	
		}
		return null;
		
	}

}
