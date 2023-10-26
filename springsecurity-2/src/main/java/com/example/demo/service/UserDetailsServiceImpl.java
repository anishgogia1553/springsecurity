package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserUtil;
//import com.example.demo.model.User;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserUtil userUtil;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		String password = userUtil.finduserByUsername(username);
		if (username == null || password == null )
			throw new UsernameNotFoundException(username);


		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		return new org.springframework.security.core.userdetails.User(username, password,
				grantedAuthorities);
	}
}