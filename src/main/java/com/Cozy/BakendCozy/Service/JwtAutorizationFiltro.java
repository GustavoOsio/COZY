package com.Cozy.BakendCozy.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtAutorizationFiltro extends BasicAuthenticationFilter {

	public JwtAutorizationFiltro(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");

		SecretKey secretKey = new SecretKeySpec(
				"$2a$10$DIaePA39XOrinXhp9GO3q.698Sb8cmg..6b.yI8XiAXuJ3ObQ7YnWOsio".getBytes(),
				SignatureAlgorithm.HS256.getJcaName());
		if (!requiresAuthentication(header)) {
			chain.doFilter(request, response);
			return;
		}
		boolean validationToken;
		Claims toke = null;
		try {
			toke = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(header.replace("Bearer ", "")).getBody();
			validationToken = true;
		} catch (JwtException e) {
			validationToken = false;
		}

		UsernamePasswordAuthenticationToken authentication = null;
		if (validationToken) {
			String username = toke.getSubject();
			Object roles = toke.get("authorities");

			Collection<? extends GrantedAuthority> authorities = Arrays.asList(
					new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthoritiesMixin.class)
							.readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));
			authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

	protected boolean requiresAuthentication(String header) {
		if (header == null || !header.startsWith("Bearer ")) {
			return false;
		}
		return true;
	}

}
