package com.agenda.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.agenda.api.users.domain.User;
import com.agenda.api.users.domain.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = repo
					.findByEmail(email)
					.orElseThrow(() -> new UsernameNotFoundException(email));
		
		return new UserAuth(user);
	}

	
}
