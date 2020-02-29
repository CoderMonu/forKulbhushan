package com.airtel.mdm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.airtel.mdm.auditable.AuditorAwareImpl;
import com.airtel.mdm.entity.Policy;
import com.airtel.mdm.repository.PolicyRepository;
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@RestController
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class AirtelmdmAppApplication {
	 @Bean
	    public AuditorAware<String> auditorAware() {
	        return new AuditorAwareImpl();
	    }
	public static void main(String[] args) {
		SpringApplication.run(AirtelmdmAppApplication.class, args);
	}
	  @Autowired
		private PolicyRepository repository;
	     @PostMapping("/createPolicy")
	     public Policy saveBook(@RequestBody Policy policy) {
	    	 return repository.save(policy);
	    	 
	     }
	     @PutMapping("/update/{id}")
	     public String updateBook(@PathVariable long id,@RequestBody Policy policyObj) {
	    	 Policy policy=repository.findById(id).get();
	    	 policy.setPolicyName(policyObj.getPolicyName());
	    	 policy.setDescription(policyObj.getDescription());
	    	 policy.setStatus(policyObj.getStatus());
		/*
		 * policy.setAppName(policyObj.getAppName());
		 * policy.setAppId(policyObj.getAppId());
		 * policy.setAppType(policyObj.getAppType());
		 * policy.setPackageName(policyObj.getPackageName());
		 */
	    	 policy.setNetworkManagementConfig(policyObj.getNetworkManagementConfig());
	    	 
	    	 repository.save(policy);
	    	 return "policy updated";	 
	    	 
	     }
	     @DeleteMapping("/delete/{id}")
	     public String deleteBook(@PathVariable long id) {
	    	 repository.deleteById(id);
	    	 return "book deleted";
	     }
	     @GetMapping("/getInfo/{id}")
	     public void  getInfo(@PathVariable long id) {
	    	 System.out.println(repository.findLastChangeRevision(id));
	    	 System.out.println("now all will come");
	    	 
	    	 //repository.findRevisions(id).getContent();
	    	 //return repository.findRevisions(id);
	     }
	     
	    // @GetMapping("/getInfo/{id}")
	     
	
	
	

}
