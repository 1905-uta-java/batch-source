package com.revature.intercom;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Account;

@FeignClient(name="account-service", fallback=AccountClientFallback.class)
public interface AccountClient {
	
	@GetMapping("accounts/customer/{customerId}")
	public List<Account> getAccountsByCustomerId(@PathVariable("customerId") Integer customerId);

}
