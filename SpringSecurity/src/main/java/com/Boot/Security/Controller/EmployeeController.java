package com.Boot.Security.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	
	
	
	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser() {
		return ResponseEntity.ok("Am a normal User");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin1")
	public ResponseEntity<String> adminUser() {
		return ResponseEntity.ok("Am a admin user");
	}
	
	
	@GetMapping("/public")
	
	public ResponseEntity<String> publicUser() {
		return ResponseEntity.ok("Am a Public user");
	}

}
