package com.mnemonic.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnemonic.service.JWTService;

@RestController
@RequestMapping("/api/basicAuth")
@ComponentScan("com.mnemonic.service")
public class BasicAuthController {
	
	@Autowired
	JWTService jwtService;
	
	
	@RequestMapping("/validate")
	public Map<String,String> userIsValid() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User currentUser = (User) auth.getPrincipal();
		String name = currentUser.getUsername();
		String role = currentUser.getAuthorities().toArray()[0].toString();
		String token = jwtService.generateToken(name, role);
		
		
		//return "{\"result\" : \"ok\"}";
		
		Map<String, String> results = new HashMap<>();
		results.put("result", token);
		return results;
		
		
	}

}
