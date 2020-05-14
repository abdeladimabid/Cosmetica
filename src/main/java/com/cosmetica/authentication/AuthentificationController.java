package com.cosmetica.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetica.iservices.IAdminService;
import com.cosmetica.services.CosmeticaUserDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("COSMETICA")
public class AuthentificationController {
	@Autowired
	JwtUtil jwtokenUtil;
	
	@Autowired
	CosmeticaUserDetailsService cusmeticaUserDetailsService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	IAdminService ius;

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		try {
			String password = authentificationRequest.getPassword();
			String hashed = ius.verifyPassword(password);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), hashed));
				
		} catch (BadCredentialsException e) {
			throw new Exception("incorrect username ou password",e);
		}
		
		final UserDetails userdetails=cusmeticaUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		final String jwt=jwtokenUtil.generateToken(userdetails);
		
		return ResponseEntity.ok().body(new AuthentificationResponse(jwt));
	}
}
