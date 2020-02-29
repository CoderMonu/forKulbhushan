package com.airtel.mdm.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.airtel.mdm.auditable.Auditable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "appentity")
@Audited
public class AppEntity extends Auditable<String>{
	@Id
	@GeneratedValue
	private String appId;

	private String appName;

	private String appType;

	private String packageName;

	//private Boolean action=true;

	@ManyToOne
	   @JoinColumn(name = "policyid")
	private Policy policyEntity;

}
