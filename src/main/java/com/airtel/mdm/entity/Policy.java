package com.airtel.mdm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.airtel.mdm.auditable.Auditable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "policy")
@EntityListeners(AuditingEntityListener.class)
@Audited
public class Policy extends Auditable<String>{
	
	private String policyName;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany(mappedBy = "policyEntity",cascade = {
	        CascadeType.ALL
	    })
	private List<AppEntity> appEntity;
	
	
	
	
	
	
	
	
	
	

	
	

}
