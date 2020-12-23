package com.agenda.api.auth.config;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.agenda.api.auth.CredentialsDTO;
import com.agenda.api.auth.UserAuth;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;	
	private JwtUtil jwtUtil;
	
	@Autowired
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
	
		try {
		
			CredentialsDTO cred = new ObjectMapper()
				.readValue(request.getInputStream(), CredentialsDTO.class);
		
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(cred.getEmail(), cred.getPassword(), new ArrayList<>());
	
			Authentication auth = authenticationManager.authenticate(authToken);
		
			return auth;
		
		} catch(IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		
		String username = ((UserAuth)auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		response.getWriter().write("{ \"Token\": \""+ token + "\" }");
		response.getWriter().flush();
 	}	
}
