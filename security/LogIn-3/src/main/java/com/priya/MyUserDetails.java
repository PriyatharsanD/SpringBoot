package com.priya;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	User u;
	public MyUserDetails(User u)
	{
		this.u=u;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return Collections.singleton(new SimpleGrantedAuthority("User"));
	}

	@Override
	public String getPassword() 
	{
		return u.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return u.getUsername();
	}

}
