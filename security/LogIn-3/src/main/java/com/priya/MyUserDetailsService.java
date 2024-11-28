package com.priya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRep rep;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = rep.findByUserName(username);
		if(u==null)
			throw new UsernameNotFoundException("Not exist");
		
		return new MyUserDetails(u);
	}

}
