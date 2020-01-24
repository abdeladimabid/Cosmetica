package com.cosmetica.Services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cosmetica.Entities.Role;
import com.cosmetica.Entities.User;
import com.cosmetica.IServices.IUserService;




@Service
public class CostumUserDetailsService implements UserDetailsService{

	@Autowired
	IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userService.getOneByUsername(username).get();
		System.out.println(new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user)));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
//		return new org.springframework.security.core.userdetails.User("l","l",new ArrayList());
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		Role role = user.getUser_role();
		authorities.add(new SimpleGrantedAuthority(role.getLabel()));
		
		return authorities;
	}
}
