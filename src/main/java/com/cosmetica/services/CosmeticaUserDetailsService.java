package com.cosmetica.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cosmetica.entities.Role;
import com.cosmetica.entities.User;
import com.cosmetica.exceptions.CosmeticaException;
import com.cosmetica.iservices.IUserService;

@Service
public class CosmeticaUserDetailsService implements UserDetailsService {
	
	@Autowired
	IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.findByUsername(username).orElseThrow(() -> new CosmeticaException(username));
		System.out.println(new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user)));
		System.out.println(getGrantedAuthorities(user));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));

	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		Role role = user.getUserRole();
		authorities.add(new SimpleGrantedAuthority(role.getLabel()));
		
		return authorities;
	}



}
